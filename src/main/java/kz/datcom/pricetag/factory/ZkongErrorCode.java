package kz.datcom.pricetag.factory;

public class ZkongErrorCode {

    public String catchError (String code, String message) {
        if (code.equals("10006")) {
            return "Срок действия учетной записи истек, пожалуйста, войдите снова";
        } else if (code.equals("10009")) {
            return "Ошибка параметра";
        } else if (code.equals("10039")) {
            return "Порядковый номер изображения может быть только от 1 до 10.";
        } else if (code.equals("10043")) {
            return "Ошибка параметра ценника";
        } else if (code.equals("10037")) {
            return "Неправильный формат изображения";
        } else if (code.equals("10038")) {
            return "Размер изображения слишком большой";
        } else if (code.equals("10041")) {
            return "Файл изображения не может быть пустым";
        } else if (code.equals("10042")) {
            return "Размер изображения не соответствует";
        } else if (code.equals("14043")) {
            return "неправильное имя пользователя или пароль";
        } else if (code.equals("14018")) {
            return "Имя пользователя не существует";
        } else if (code.equals("14022")) {
            return "Пользователь отключен";
        } else if (code.equals("14031")) {
            return "Недостаточно разрешений";
        } else if (code.equals("14038")) {
            return "Аккаунт отключен";
        } else if (code.equals("15060")) {
            return "Устройство не найдено";
        } else if (code.equals("15059")) {
            return "AP уже существует";
        } else if (code.equals("19001")) {
            return "Список товаров пуст";
        } else if (code.equals("19002")) {
            return "Список продуктов Длина больше 500";
        } else if (code.equals("19003") && message.equals("Store ID 不匹配")) {
            return "Идентификатор магазина не совпадает";
        } else if (code.equals("19003") && message.equals("Merchant ID 不匹配")) {
            return "Идентификатор продавца не совпадает";
        } else if (code.equals("19003") && message.equals("代理商 id 不匹配")) {
            return "Идентификатор агентства не совпадает";
        } else if (code.equals("19004")) {
            return "Неверный формат времени начала акции";
        } else if (code.equals("19005")) {
            return "Неверный формат времени окончания промоакции.";
        } else if (code.equals("19006")) {
            return "Идентификатор магазина не может быть пустым.";
        } else if (code.equals("19010")) {
            return "Неверный формат цены";
        } else if (code.equals("19011")) {
            return "Ошибка исходной цены";
        } else if (code.equals("19012")) {
            return "Ошибка цены участника";
        } else if (code.equals("19013")) {
            return "Неверный формат времени";
        } else if (code.equals("19014")) {
            return "Список длин продуктов больше 20000";
        } else if (code.equals("20008")) {
            return "Товар не привязан к ценнику";
        } else {
            return "Неизвестная ошибка";
        }
     }

}
