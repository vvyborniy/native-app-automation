package com.aqa.mobile.common.device;

import com.aqa.mobile.common.device.model.MobileDevice;
import com.aqa.mobile.common.exception.NoOneFreeDeviceForTestException;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

@Log4j2
public class DeviceManager {

    private final ConcurrentHashMap<String, Boolean> deviceStatusMap = new ConcurrentHashMap<>();
    private final static ThreadLocal<MobileDevice> MOBILE_DEVICE_THREAD_LOCAL = new ThreadLocal<>();
    private final DeviceStore deviceStore;

    public DeviceManager() {
        deviceStore = new DeviceStore();
        deviceStore.getDeviceList().forEach(device -> deviceStatusMap.put(device.getUdid(), true));
    }

    public MobileDevice getDeviceForTest() {
        MobileDevice device = getLocalDevice();
        if (device == null) {
            device = getFreeDeviceWithWait();
            MOBILE_DEVICE_THREAD_LOCAL.set(device);
        }
        return device;
    }

    public static MobileDevice getLocalDevice() {
        return MOBILE_DEVICE_THREAD_LOCAL.get();
    }


    @SneakyThrows
    private MobileDevice getFreeDeviceWithWait() {
        MobileDevice freeDeviceFromMap = getFreeDeviceAccordingStatusInMap();

        int attempt = 0;
        int poolingInterval = 10;

        while (freeDeviceFromMap == null && attempt < 20) {
            attempt++;
            Thread.sleep(ofSeconds(poolingInterval).toMillis());
            freeDeviceFromMap = getFreeDeviceAccordingStatusInMap();
        }

        if (freeDeviceFromMap == null) {
            throw new NoOneFreeDeviceForTestException(format("Unable to find free device for test during %s attempts with %s sec. of pooling interval",
                    attempt, poolingInterval));
        }

        log.info(format("Device with udid '%s' setting for test [%s]",
                freeDeviceFromMap.getUdid(), Thread.currentThread().getName()));
        Allure.attachment("Device for current test.", format("Device with udid '%s'", freeDeviceFromMap.getUdid()));
        return freeDeviceFromMap;
    }

    private MobileDevice getFreeDeviceAccordingStatusInMap() {
        return deviceStore.getDeviceList().stream()
                .filter(this::isDeviceStatusFree)
                .filter(this::lockDevice)
                .findFirst()
                .orElse(null); //for attempting to find free device with interval
    }

    private Boolean isDeviceStatusFree(MobileDevice device) {
        return deviceStatusMap.get(device.getUdid());
    }

    private Boolean lockDevice(MobileDevice device) {
        return deviceStatusMap.replace(device.getUdid(), true, false);
    }

    private Boolean unlockDevice(MobileDevice device) {
        return deviceStatusMap.put(device.getUdid(), true);
    }

    public void freeDevice() {
        MobileDevice currentDevice = getLocalDevice();
        if (currentDevice != null) {
            unlockDevice(currentDevice);
            MOBILE_DEVICE_THREAD_LOCAL.remove();
            log.info(format("Device '%s' was released for test [%s]", currentDevice.getUdid(), Thread.currentThread().getName()));
        }
    }
}
