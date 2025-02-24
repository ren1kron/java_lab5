package org.ren1kron.managers;

import lombok.Getter;
import lombok.Setter;
import org.ren1kron.module.Organization;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public class CollectionManager implements Iterable<Organization> {
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

                instance.filePath = filePath;
                instance.lastInitTime = LocalDateTime.now();

                instance.collection = DumpManager.loadOrganizations(filePath);
            } catch (IOException e) {
                System.err.println("Ошибка: Не удалось прочитать данные из файла. Проверьте, установили ли вы переменную окружения 'lab5' корректно и корректны ли данные в этом файле.");
                System.exit(1);
            }
        }
        return instance;
    }

    private List<Organization> collection = new ArrayList<>();
    private String filePath;
    private LocalDateTime lastInitTime;
    @Setter
    private LocalDateTime lastSaveTime;
    private static long currentId = 1;

    /**
     * Добавляет элемент в коллекцию
     * @param organization элемент, который нужно добавить
     * @return true, если элемент был добавлен
     */
    public boolean add(Organization organization) {
        return collection.add(organization);
    }

    /**
     * Обновляет элемент коллекции с данным ID
     * @param id ID организации, которую нужно обновить
     * @param organization Обновлённая организация
     * @return true, если организация была успешно обновлена
     */
    public boolean update(long id, Organization organization) {
        Organization curOrg = this.byId(id);
        if (curOrg == null)
            return false;

        organization.setId(id);

        if (!collection.remove(curOrg))
            return false;

        return collection.add(organization);
    }

    /**
     * Удаляет элемент коллекции с данным ID
     * @param id ID элемента, который нужно удалить
     * @return true, если элемент был удалён
     */
    public boolean removeById(long id) {
        return collection.removeIf(org -> org.getId() == id);
    }

    /**
     * Удаляет элемент коллекции с данным индексом
     * @param index индекс элемента, который нужно удалить
     */
    public void removeByIndex(int index) {
        collection.remove(index);
    }

    public void removeGreater(Organization organization) {
        collection.removeIf(e -> organization.compareTo(e) > 0);
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

    /**
     * Сохраняет коллекцию в файл
     * @throws IOException Если произошла ошибка при сохранении
     */
    public void save() throws IOException {
        DumpManager.saveOrganizations(collection, filePath);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Очищает коллекцию
     */
    public void clear() {
        collection.clear();
    }

    /**
     * @return Итератор коллекции
     */
    @Override
    public Iterator<Organization> iterator() {
        return collection.iterator();
    }
}
