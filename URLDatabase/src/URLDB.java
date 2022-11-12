import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class URLDB {
    static List<URL> urlList=new ArrayList<>();

    static boolean isPresent(String str){
        for(URL u:urlList){
            if(u.getUrl().equalsIgnoreCase(str)){
                return true;
            }
        }
        return false;
    }

    static void storeUrl(String url)  {    //1. logic for storing url
        URL u=new URL();
        u.setUrl(url);
        if(urlList.add(u)){
            System.out.println("URL stored successfully\n");

        }
    }

    static int get(String url){       //2. logic for getting the unique id of the giver URL
        for(URL u:urlList){
            if(u.getUrl().equals(url)){
                u.setCount(u.getCount()+1);
                return u.getUniqueID();
            }
        }
        return 0;
    }
    static int count(String url){      //3. logic to get the latest usage
        for(URL u:urlList){
            if(u.getUrl().equals(url)){
                return u.getCount();
            }
        }
        return 0;
    }

    static List<String> listURL() throws JsonProcessingException {           //logic for listing url


        List<String> list=new ArrayList<>();
        for(URL u:urlList){
            list.add(new ObjectMapper().writeValueAsString(u));
        }
        if(list.isEmpty()){
            System.out.println("Database is empty\n");
            return null;
        }
        return list;

    }

}
