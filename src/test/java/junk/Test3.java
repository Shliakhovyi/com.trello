package junk;

public class Test3 {

    //Дан текст. Некоторые его фрагменты выделены группами символов ##. Заменить выделение группами символов '<' и '>)'.
    // Пример: 'Это ##тестовый пример## для задачи ##на## строки' преобразуется в 'Это <тестовый> пример для задачи <на>
    // строки'

    public static void main(String[] args) {
        String exmpl = "Это ##тестовый пример## для задачи ##на## строки";

        String solution = exmpl.replace(" ##", " <");
        solution = solution.replace("## ", "> ");

        System.out.println(solution);
    }
}
