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
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioAnaliseDadosApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(DesafioAnaliseDadosApplication.class, args);

        SalesService salesService = new SalesService();
        SellerService sellerService = new SellerService();
        ClientService clientService = new ClientService();
        ArchiveService archiveService = new ArchiveService();

        Path path = archiveService.getArchive("C:\\Users\\SouthSystem\\Desktop\\desafio\\");
        WatchService watcher = FileSystems.getDefault().newWatchService();
        path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.OVERFLOW);

        WatchKey key;
        while (((key = watcher.take()) != null)) {
            List<Seller> sellers = new ArrayList<>();
            List<Client> clients = new ArrayList<>();
            List<Sales> sales = new ArrayList<>();
            for (WatchEvent<?> event : key.pollEvents()) {
                String filename = event.context().toString();
                if (Files.isDirectory(path)) {
                    DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
                    for (Path cam : directoryStream) {
                        BufferedReader bufferedReader = archiveService.getBufferedReader(cam);
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
                    }
                }
            }
            System.out.println("Quantidade de vendedor no arquivo de entrada: " + sellerService.getSellerSize(sellers));
            System.out.println("Quantidade de clientes no arquivo de entrada: " + clientService.getClientsize(clients));
            System.out.println("ID da venda mais cara: " + salesService.mostExpensiveSaleId(sales));
            System.out.println("O pior vendedor: " + sellerService.getWorstSeller(sales));
            key.reset();
        }
    }
}


