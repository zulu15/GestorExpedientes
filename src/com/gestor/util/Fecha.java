/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestor.util;


public class Fecha {

    public static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());

    }

    public static java.sql.Date getCurrentDate(java.util.Date today) {
        return new java.sql.Date(today.getTime());
    }

}
