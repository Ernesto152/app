package tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import tfc.com.pe.tfc_cobranzas_app.management.model.Phone;

public class PhoneDao_Impl implements PhoneDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfPhone;

  private final SharedSQLiteStatement __preparedStmtOfTruncate;

  public PhoneDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPhone = new EntityInsertionAdapter<Phone>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `phone`(`phone_type`,`description`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Phone value) {
        if (value.getPhoneType() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPhoneType());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
      }
    };
    this.__preparedStmtOfTruncate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM phone";
        return _query;
      }
    };
  }

  @Override
  public void insert(Phone... phones) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfPhone.insert(phones);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void truncate() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfTruncate.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfTruncate.release(_stmt);
    }
  }

  @Override
  public List<Phone> getAll() {
    final String _sql = "SELECT * FROM phone ORDER BY phone_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfPhoneType = _cursor.getColumnIndexOrThrow("phone_type");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Phone> _result = new ArrayList<Phone>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Phone _item;
        _item = new Phone();
        final String _tmpPhoneType;
        _tmpPhoneType = _cursor.getString(_cursorIndexOfPhoneType);
        _item.setPhoneType(_tmpPhoneType);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
