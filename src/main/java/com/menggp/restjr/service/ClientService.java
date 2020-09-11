package com.menggp.restjr.service;

import com.menggp.restjr.model.Client;

import java.util.List;

/**
 *  Интрефейс описывающий CRUD операции над клиентом
 */
public interface ClientService {

    /**
     *   Создает нового клиента
     * @param client - клиент для создания
     */
    void create(Client client);

    /**
     * Возврящает список всех имеющихся клиантов
     * @return список клиентов
     */
    List<Client> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - одъект клиента с заданным ID
     */
    Client read(int id);

    /**
     * Обновляет клиента с заданным ID, в соответствии с переданным клиентом
     * @param client - клиент в соответствии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client client, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клианта, которого нужно удалить
     * @return - true если клиент был удален, иниче false
     */
    boolean delele(int id);

}
