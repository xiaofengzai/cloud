package com.wen.sys;

public class MySQL5DialectWithoutFK extends org.hibernate.dialect.MySQL5Dialect {
    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        return " alter "+ foreignKey[0] +" set default ''" ;
    }
}