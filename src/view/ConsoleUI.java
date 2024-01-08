package view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.Controller;
import view.menu.MainMenu;
import view.menu.Menu;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Controller controller;
    private int countMenu;
    private boolean work;
    private Menu mainMenu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.controller = new Controller(this);
        this.mainMenu = new MainMenu(this);
        this.work = true;
        this.countMenu = 0;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        menu(mainMenu);
    }

    public void menu(Menu menu) {
        countMenu++;
        while (work) {
            printMenu(menu);
            execute(menu);
        }
        countMenu--;
        if (countMenu != 0) {
            work = true;
        }
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }

    // public void sortByAge() {
    // controller.sortByAge();
    // }

    // public void sortByName() {
    // controller.sortByName();
    // }

    // public void sortBySurname() {
    // controller.sortBySurname();
    // }

    // public void sortByPatronymic() {
    // controller.sortByPatronymic();
    // }

    public void getAnimalsList() {
        controller.getAnimalsList();
    }

    public void addAnimal(String genius) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        controller.addAnimal(name, getDate("Укажите дату рождения \"год-месяц-день\": ", false), genius);
    }

    private int getNumber() {
        int chois = -1;
        String temp = scanner.nextLine();
        if (checkTextForInt(temp)) {
            chois = Integer.parseInt(temp);
        }
        return chois;
    }

    private String getDate(String text, boolean check) {
        String date = new String();
        boolean flag = true;
        while (flag) {
            System.out.print(text);
            date = scanner.nextLine();
            if (date.length() == 0 && check) {
                return null;
            }
            if (checkDate(date)) {
                flag = false;
            }
        }
        return date;
    }

    private boolean checkDate(String data) {
        Pattern pattern = Pattern.compile("(\\d{4})[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private void execute(Menu menu) {
        String line = scanner.nextLine();
        System.out.println();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize() && numCommand > 0) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);

    }

    public void back() {
        work = false;
    }

    public void addSkill() {
        getAnimalsList();
        System.out.print("Введите id животного: ");
        int id = getNumber();
        if (controller.checkId(id)) {
            System.out.print("Введите навык: ");
            String skill = scanner.nextLine();
            controller.addSkill(id, skill);
        }
        else printAnswer(INPUT_ERROR);
    }

    public void remove() {
        getAnimalsList();
        System.out.print("Введите id животного: ");
        int id = getNumber();
        if (controller.checkId(id)) {
            controller.remove(id);
        }
        else printAnswer(INPUT_ERROR);
    }

}
