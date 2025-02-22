package org.ren1kron.managers;

import lombok.Getter;
import org.ren1kron.module.Organization;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionManager {
    private static CollectionManager instance;
    private CollectionManager() {}
    public static CollectionManager getInstance() {
        if (instance == null) {
            try {
                instance = new CollectionManager();

                String filePath = System.getenv("lab5");

                if (filePath == null || filePath.isEmpty()) {
                    System.err.println("Ошибка: Не задан путь к файлу. Установите переменную окружения 'lab5'");
                    System.exit(1);
                }

                instance.collection = DumpManager.loadOrganizations(filePath);
            } catch (IOException e) {
                System.err.println("Ошибка: Не удалось прочитать данные из файла. Проверьте, установили ли вы переменную окружения 'lab5' корректно и корректны ли данные в этом файле.");
                System.exit(1);
            }
        }
        return instance;
    }

    @Getter
    private List<Organization> collection = new ArrayList<>();

    private static long currentId = 1;

    public boolean add(Organization organization) {
        return collection.add(organization);
    }

    /**
     * Удаляет элемент коллекции с данным ID
     * @param id ID элемента, который нужно удалить
     * @return true, если элемент был удалён
     */
    public boolean remove(long id) {
        return collection.removeIf(org -> org.getId() == id);
    }


    /**
     * Ищет в коллекции организацию по ID
     * @param id ID организации, которую нужно вернуть
     * @return Организацию с данным ID или null, если элемента с таким ID нет в коллекции
     */
    public Organization byId(long id) {
        for (Organization organization : collection) {
            if (organization.getId() == id)
                return organization;
        }
        return null;
    }

    /**
     * Находит первый не занятый ID
     * @return Свободный ID
     */
    public long getFreeId() {
        while (byId(currentId) != null)
            if (++currentId < 0)
                currentId = 1;
        return currentId;
    }
}
