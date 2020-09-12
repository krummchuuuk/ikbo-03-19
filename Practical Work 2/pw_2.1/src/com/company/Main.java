package com.company;

class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender ) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName()  {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String Email) {
        email = Email;
    }

    @Override
    public String toString() {
        return "Author's name "+getName()+" ("+getGender()+") email:"+getEmail();
    }
}

public class Main {

    public static void main(String[] args) {
	    Author blogger = new Author("Thomas", "tomblog@gmail.com", 'm');
	    blogger.setEmail("blod_new@mail.ru");
	    System.out.print(blogger.toString());
    }
}
