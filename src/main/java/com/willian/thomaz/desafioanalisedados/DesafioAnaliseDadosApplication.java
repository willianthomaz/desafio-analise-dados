package com.willian.thomaz.desafioanalisedados;

import com.willian.thomaz.desafioanalisedados.entity.Client;
import com.willian.thomaz.desafioanalisedados.entity.Item;
import com.willian.thomaz.desafioanalisedados.entity.Sales;
import com.willian.thomaz.desafioanalisedados.entity.Seller;
import com.willian.thomaz.desafioanalisedados.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioAnaliseDadosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioAnaliseDadosApplication.class, args);

        try {
            ArchiveService archiveService = new ArchiveService();
            File archive = archiveService.getArchive("C:\\Users\\SouthSystem\\Desktop\\doc.dat");
            FileReader fileReader = archiveService.getFileReader(archive);
            BufferedReader bufferedReader = archiveService.getBufferedReader(fileReader);
            List<Seller> sellers = new ArrayList<>();
            List<Client> clients = new ArrayList<>();
            List<Sales> sales = new ArrayList<>();

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.contains("ç")) {
                    List<String> list = Arrays.asList(line.split("ç"));
                    List<String> list2 = Arrays.asList(list.get(2).replace("[", "").replace("]", "").split(","));
                    if (list.contains("001")) {
                        Seller seller = new Seller(Long.valueOf(list.get(0)), Long.valueOf(list.get(1)), list.get(2),Double.valueOf(list.get(3)));
                        sellers.add(seller);
                    }
                    if (list.contains("002")) {
                        Client client = new Client(Long.valueOf(list.get(0)), Long.valueOf(list.get(1)), list.get(2), list.get(3));
                        clients.add(client);
                    }
                    if (list.contains("003")) {
                        List<Item> items = new ArrayList<>();
                        for (String itemm : list2) {
                            String[] list3 = itemm.split("-");
                            Item item = new Item(Long.parseLong(list3[0]), Long.parseLong(list3[1]), Double.parseDouble(list3[2]));
                            items.add(item);
                        }
                        Sales sale = new Sales(Long.valueOf(list.get(0)), Long.valueOf(list.get(1)), items, list.get(3));
                        sales.add(sale);
                    }
                }
            }
                bufferedReader.close();
                fileReader.close();
                System.out.println(sellers);
                System.out.println(clients);
                System.out.println(sales);
            }catch(IOException e){
            e.printStackTrace();
            }
        }
}



