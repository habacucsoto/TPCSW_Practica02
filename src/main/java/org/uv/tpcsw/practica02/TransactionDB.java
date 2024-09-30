
package org.uv.tpcsw.practica02;

import java.sql.Connection;

public abstract class TransactionDB <T> {
protected T pojo;
protected TransactionDB(T pojo){
    this.pojo=pojo;
}



public abstract boolean execute (Connection con) ;




}
