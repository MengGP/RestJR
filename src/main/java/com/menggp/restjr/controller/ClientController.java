package com.menggp.restjr.controller;

import com.menggp.restjr.model.Client;
import com.menggp.restjr.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс обрабатывает REST-запросы
 *      - является REST-контроллером
 *      - реализует логику обработки клиентских запросов
 */
@RestController
public class ClientController {

    /*
    // Внедрение зависимости ClientService - через конструктор
    private  final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
     */

    // Внедрение зависимости через
    @Autowired
    ClientService clientService;

    /**
     * Создание клиента - отвечает на POST-запрос с адресом "/clients"
     * @param client - создаваемый клиент
     * @return - возвращаем статус опарации
     */
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Получение списка клиентов - отвечает на GET-запрос с адерсом "/clients"
     * @return - возвращаем список клиентов, иначе статус NOT_FOUNT
     */
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    /**
     * Получение клиента по ID - отвечает на GET-зарос с параметром {id} с адресом "/clients/{id}"
     * @param id - id запрашиваемого клиента
     * @return - возващаем клиента с запрашиваемым ID, если нет статус NOT_FOUND
     */
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name="id") int id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Обновление данных клиента с заданным ID - отвечает на PUT-запрос c параметром {id} с адресом "/clients/{id}"
     * @param id - id обновляемого клиента
     * @param client - новый набор данных для клиента
     * @return - возвращаем статус обновлен/не обновлен
     */
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") int id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    /**
     * Удаление клиента по ID - отвечает на DEL-запрос с параметром {id} с адресом "/clients/{id}"
     * @param id - id удаляемого клиента
     * @return - возвращаем статус операции
     */
    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") int id) {
        final boolean deleted = clientService.delele(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }





}
