package ua.opnu;

public class TimeSpan {
    // --- Поля класу ---
    private int hours;
    private int minutes;

    // --- Конструктори ---
    // 1. Без аргументів
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // 2. Один аргумент — хвилини
    public TimeSpan(int minutes) {
        if (minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = minutes / 60;
            this.minutes = minutes % 60;
        }
    }

    // 3. Два аргументи — години та хвилини
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours + minutes / 60;
            this.minutes = minutes % 60;
        }
    }

    // 4. Один аргумент типу TimeSpan
    public TimeSpan(TimeSpan other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
    }

    // --- Гетери ---
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // --- Методи додавання часу ---
    // 1. Додає години та хвилини
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // 2. Додає хвилини
    public void add(int minutes) {
        if (minutes < 0) return;
        this.minutes += minutes;
        normalize();
    }

    // 3. Додає інший TimeSpan
    public void add(TimeSpan span) {
        add(span.hours, span.minutes);
    }

    // --- Методи віднімання часу ---
    // 1. Віднімає години та хвилини
    public void subtract(int hours, int minutes) {
        int total = this.getTotalMinutes() - (hours * 60 + minutes);
        if (total < 0) return;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    // 2. Віднімає хвилини
    public void subtract(int minutes) {
        int total = this.getTotalMinutes() - minutes;
        if (total < 0) return;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    // 3. Віднімає інший TimeSpan
    public void subtract(TimeSpan span) {
        int total = this.getTotalMinutes() - span.getTotalMinutes();
        if (total < 0) return;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    // --- Допоміжні методи ---
    private void normalize() {
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // Для зручності тестування
    @Override
    public String toString() {
        return String.format("%d hours %d minutes", hours, minutes);
    }
}
