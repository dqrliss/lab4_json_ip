package org.example;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class exam {
    private String subject;
    private int mark;
    public boolean checking_for_excellent_student() {
        return mark == 9 || mark == 10;
    }
    public String toString() {
        return "subject: " + subject + ", " + "mark: " + mark + "\n";
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        exam Exam = (exam) o;
        if (!Objects.equals(subject, Exam.subject)) return false;
        // if (subject != null ? !subject.equals(Exam.subject) : Exam.subject != null) return false;
        return String.valueOf(mark) != null ? String.valueOf(mark).equals(String.valueOf(Exam.mark)) : String.valueOf(Exam.mark) == null;
    }

    public void input(Scanner in) throws IOException {
        String str = in.nextLine();
        int index = str.lastIndexOf(" ");
        subject = str.substring(0, index);
        mark = Integer.parseInt(str.substring(index + 1));
    }
    public void output() {
        System.out.print(this);
    }
}