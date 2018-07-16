package com.epam.agency;

import com.epam.agency.config.AppConfig;
import com.epam.agency.domain.Client;
import com.epam.agency.service.impl.ClientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ClientService clientService = (ClientService) context.getBean("clientService");
//        Client newclient = new Client("kovalev","client");
//        clientService.create(newclient);
//        List<Client> clients =clientService.findAll();
//        for(Client client:clients){
//            System.out.println(client);
////            client.setPassword("client");
////            clientService.update(client);
//            if(client.getId()==7){
//                clientService.delete(client);
//            }
//        }
//        List<Client> deleteclients =clientService.findAll();
//        for(Client client:deleteclients){
//            System.out.println(client);
//        }
        Client client = clientService.findById(4);
        System.out.println(client);
    }
}
