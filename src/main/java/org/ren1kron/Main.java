package org.ren1kron;

import org.ren1kron.managers.CollectionManager;
import org.ren1kron.managers.CommandManager;
import org.ren1kron.managers.DumpManager;
import org.ren1kron.module.*;
import org.ren1kron.utils.Runner;
import org.ren1kron.utils.console.Console;
import org.ren1kron.utils.console.StandardConsole;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        export lab5="/Users/ren1kron/Java/tink_jan2025/proga_lab5_anya2/organizations.json"

        Console console = new StandardConsole(new BufferedReader(new InputStreamReader(System.in)));
        Runner runner = new Runner(console);

        console.printGritting("Приветствуем вас в приложении для модерации списка Организаций!");
        console.printGritting("Введите 'help' для получения справки по командам");

        runner.interactiveMode();
    }

//    // Создаем пример коллекции организаций
//        List<Organization> organizations = new ArrayList<>();
//        organizations.add(new Organization(
//                1,
//                "Organization One",
//                new Coordinates(10, 20.0),
//                LocalDateTime.now(),
//                100000,
//                "Full Name One",
//                50,
//                OrganizationType.PUBLIC,
//                new Address("Street", new Location(1, 1, "LA"))
//        ));
//
//        // Путь к файлу для сохранения JSON
//        String filePath = "organizations.json";
//
//        try {
//
//
//            // Загрузка коллекции из файла
//            List<Organization> loadedOrganizations = DumpManager.loadOrganizations(filePath);
//            System.out.println("Загружено организаций: " + loadedOrganizations.size());
//
//            // Сохранение коллекции в файл
//            DumpManager.saveOrganizations(organizations, filePath);
//            System.out.println("Сохранение успешно!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
}