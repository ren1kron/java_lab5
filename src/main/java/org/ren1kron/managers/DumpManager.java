package org.ren1kron.managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.ren1kron.module.Organization;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class DumpManager {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Регистрируем модуль для поддержки LocalDateTime и других классов Java 8 даты/времени
        mapper.registerModule(new JavaTimeModule());
        // Форматирование вывода для красоты
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    // Метод для сохранения коллекции организаций в JSON-файл
    public static void saveOrganizations(Collection<Organization> organizations, String filePath) throws IOException {
        mapper.writeValue(new File(filePath), organizations);
    }

    // Метод для загрузки коллекции организаций из JSON-файла
    public static List<Organization> loadOrganizations(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), new TypeReference<List<Organization>>() {
        });
    }
}