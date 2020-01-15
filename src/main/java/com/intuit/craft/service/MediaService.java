package com.intuit.craft.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * upload pic and video
 *
 * /*
 * Given a log file for the home page visits of users for a month. Tab separated. Code with input validations and unit tests.
 *
 *  productId    userId    timestamp (yyyy-mm-dd hh:mm)
 *  p1           u1         2019-01-02 02:12
 *  p3           u2         2019-01-02 04:13
 *  p1           u1         2019-01-02 03:12
 *  p12          u1         2019-01-02 02:20
 *  p1           u1         2019-01-02 06:12
 *  p89          u11        2019-01-03 02:20
 *  p1           u10        2019-01-03 03:20
 *  p1           u20        2019-01-03 02:19
 *  p1           u20        2019-01-03 02:20
 *  p11          u2         2019-01-05 02:21
 *  p11          u1         2019-01-06 02:22
 *  p12          u19        2019-01-08 02:20
 *
 *
 *
 * 1.) For each product how many unique users have visited the product ?
 *
 * Output
 * p1:3
 * p3:1
 * p12:2 ... and so on
 *
 * 2.) Given a range of timestamp find the number of home page visits in that duration. Input will be in format:
 * (yyyy-mm-dd hh - yyyy-mm-dd hh)
 *
 * e.g.
 *
 * Input
 * 2019-01-01 00 - 2019-01-03 00
 *
 * Output
 * 5
 *
 *
 *
 * https://www.springboottutorial.com/spring-boot-with-mysql-and-oracle
 * https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-mysql
 **/

public class MediaService {


}
