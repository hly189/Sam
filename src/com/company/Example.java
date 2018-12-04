package com.company;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
public class Example
{
    public static HashMap<String, String> initializeDependent (ArrayList<HashMap<String, String>> listCommand){
        HashMap<String, String> listDependElement = new HashMap<>();
        for (HashMap<String, String> hash: listCommand){
            Set<String> key = hash.keySet();
            String keyName = key.iterator().next();
            if (keyName.equals("DEPEND") == true){
                String[] wordArray = hash.get(keyName).split("\\s+");
                String dependItems = String.join(" ", Arrays.copyOfRange(wordArray, 1, wordArray.length));
                listDependElement.put(wordArray[0], dependItems);
            }
        }
        return listDependElement;
    }
    public static void showExsitedItems (HashSet<String> installedSet){
        if (installedSet.isEmpty()){
            System.out.println("None");
        }else{
            for (String item : installedSet){
                System.out.println(item);
            }
        }
    }
    public static void installElement (String installItem, HashMap<String, String> dependList, HashSet<String> installedSet){

        if (installedSet.contains(installItem) == false){
            System.out.println("Installing " + installItem);
            installedSet.add(installItem);
            if (dependList.containsKey(installItem) == true){
                String[] listItems = dependList.get(installItem).split("\\s+");
                for (String item : listItems){
                    if (installedSet.contains(item) == false) {
                        installedSet.add(item);
                        System.out.println("Installing " + item);
                    }else{
                        System.out.println("Installed: " + item);
                    }
                }
            }

        }else{
            System.out.println("Installed: " + installItem);
        }
    }

    public static boolean isDependItem (String item, HashMap<String, String> dependListItem) {
        boolean checking = false;
        for (String key : dependListItem.keySet()){
            String dependItems = dependListItem.get(key);
            if (dependItems.contains(item) == true){
                checking = true;
            }
        }
        return checking;
    }

    public static void removeItem (String itemRemove, HashMap<String, String> dependList, HashSet<String> listExisted){

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCommand;
        ArrayList<HashMap<String, String>> listCommand = new ArrayList<>();
        HashSet<String> installedItemSet = new HashSet<>();

        boolean inputindication = true;
        do {
            inputCommand = scanner.nextLine();
            String[] wordArray = inputCommand.split("\\s+");
            String indicateWord = wordArray[0];
            String command;
            if (wordArray.length - 1 != 0 ) {
                 command = String.join(" ", Arrays.copyOfRange(wordArray, 1, wordArray.length));
            }else{
                command = "";
            }
            HashMap<String, String> hashCommand = new HashMap<>();
            if (indicateWord.equals("END") == false){
                hashCommand.put(indicateWord, command);
                listCommand.add(hashCommand);
            }else{
               inputindication =false;
            }

        }while (inputindication == true);

        scanner.close();

        HashMap<String, String> listDependElement = initializeDependent(listCommand);
        for (int i = 0; i < listCommand.size(); i++){
            HashMap<String, String> hashListCommand = listCommand.get(i);
            Set<String> keySet = hashListCommand.keySet();
            String keyName = keySet.iterator().next();
            if (keyName.equals("INSTALL")) {
                String installItem = hashListCommand.get("INSTALL");
                installElement(installItem, listDependElement, installedItemSet);
            }else if (keyName.equals("REMOVE")){
                String removeItem = hashListCommand.get("REMOVE");
                removeItem(removeItem, listDependElement, installedItemSet);
            }else if (keyName.equals("LIST")){
                showExsitedItems(installedItemSet);
            }
        }


    }

      
}