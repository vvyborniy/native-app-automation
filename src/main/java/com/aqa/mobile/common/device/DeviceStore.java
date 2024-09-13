package com.aqa.mobile.common.device;

import com.aqa.mobile.common.device.model.MobileDevice;
import com.aqa.mobile.common.exception.ReadDeviceJsonFileException;
import com.aqa.mobile.config.Environment;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
@Log4j2
public class DeviceStore {

    private final List<MobileDevice> deviceList;

    public DeviceStore() {
        deviceList = readDeviceJson();
    }

    private List<MobileDevice> readDeviceJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(Environment.environment.devicesJsonPath()), new TypeReference<>() {
            });
        } catch (IOException e) {
            log.error("Exception while read devices json file");
            throw new ReadDeviceJsonFileException(e);
        }
    }
}
