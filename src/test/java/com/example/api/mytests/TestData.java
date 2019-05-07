package com.example.api.mytests;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

public class TestData {
    public static final Operation INSERT_DRIVER 
    = Operations.insertInto("driver")
    .columns("driver_id","driver_name", "email", "msisdn", "status")
    .values(1,"axel","axel@gmail.com", "0782980090",0)
    .values(2,"romeo","romeo@gmail.com", "0782980090",0)
    .build();
    public static final Operation DELETE_ALL
    = Operations.deleteAllFrom("driver");
}
