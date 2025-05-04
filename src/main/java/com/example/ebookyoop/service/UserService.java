package com.example.ebookyoop.service;

import com.example.ebookyoop.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static final String FILE_NAME = "User.txt";


    private String getFilePath() {
        return System.getProperty("user.dir") + File.separator + FILE_NAME;
    }
    public void saveUser(User user){
        try{
            File file = new File(getFilePath());

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
                String line = user.getId() + "," + user.getFirstName() + ","+ user.getLastName() +"," + user.getEmail() + "," + user.getPassword() + "," + user.getRole();
                bw.write(line);
                bw.newLine();
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(getFilePath()))){
            String line;
            while ((line=br.readLine())!= null){
                String[] parts = line.split(",");
                if(parts.length==6){
                    User user = new User();
                    user.setId(Integer.parseInt(parts[0]));
                    user.setName(parts[1]);
                    user.setLastName(parts[2]);
                    user.setEmail(parts[3]);
                    user.setPassword(parts[4]);
                    user.setRole(parts[5]);

                    users.add(user);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }

    public User findUser(String email,String password){
//        get all users
        List<User> userList = getUsers();
//        current user
        User currentUser = null;
//        Search each user email and password
        for (User u:userList) {
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                if(currentUser==null){
                    currentUser = u;
                }
            };
        }
//        return user
        return currentUser;
    }
}
