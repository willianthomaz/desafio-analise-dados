package com.willian.thomaz.desafioanalisedados;

import com.willian.thomaz.desafioanalisedados.entity.Client;
import com.willian.thomaz.desafioanalisedados.entity.Sales;
import com.willian.thomaz.desafioanalisedados.entity.Seller;
import com.willian.thomaz.desafioanalisedados.service.ArchiveService;
import com.willian.thomaz.desafioanalisedados.service.ClientService;
import com.willian.thomaz.desafioanalisedados.service.SalesService;
import com.willian.thomaz.desafioanalisedados.service.SellerService;
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

        SalesService salesService = new SalesService();
        SellerService sellerService = new SellerService();
        ClientService clientService = new ClientService();
        List<Seller> sellers = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Sales> sales = new ArrayList<>();

        try {
            ArchiveService archiveService = new ArchiveService();
            File archive = archiveService.getArchive("C:\\Users\\SouthSystem\\Desktop\\doc.dat");
            FileReader fileReader = archiveService.getFileReader(archive);
            BufferedReader bufferedReader = archiveService.getBufferedReader(fileReader);

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.contains("ç")) {
                    List<String> list = Arrays.asList(line.split("ç"));
                    List<String> list2 = Arrays.asList(list.get(2).replace("[", "").replace("]", "").split(","));
                    if (list.contains("001")) {
                        sellers.add(sellerService.createSeller(list));
                    }
                    if (list.contains("002")) {
                        clients.add(clientService.createClient(list));
                    }
                    if (list.contains("003")) {
                        sales.add(salesService.createSales(list, list2));
                    }
                }
            }
                bufferedReader.close();
                fileReader.close();
                System.out.println("Quantidade de vendedor no arquivo de entrada: " + sellerService.getSellerSize(sellers));
                System.out.println("Quantidade de clientes no arquivo de entrada: " + clientService.getClientsize(clients));
                System.out.println("ID da venda mais cara: " + salesService.mostExpensiveSaleId(sales));
                System.out.println("O pior vendedor: " + sellerService.getWorstSeller(sales));
            }catch(IOException e){
            e.printStackTrace();
            }
        }
}



