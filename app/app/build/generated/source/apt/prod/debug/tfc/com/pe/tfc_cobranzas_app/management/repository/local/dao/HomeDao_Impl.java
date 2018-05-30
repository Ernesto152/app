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
import tfc.com.pe.tfc_cobranzas_app.management.model.Home;

public class HomeDao_Impl implements HomeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfHome;

  private final SharedSQLiteStatement __preparedStmtOfTruncate;

  public HomeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHome = new EntityInsertionAdapter<Home>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `home`(`address_type`,`description`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Home value) {
        if (value.getAddressType() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAddressType());
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
        final String _query = "DELETE FROM home";
        return _query;
      }
    };
  }

  @Override
  public void insert(Home... homes) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfHome.insert(homes);
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
  public List<Home> getAll() {
    final String _sql = "SELECT * FROM home ORDER BY address_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfAddressType = _cursor.getColumnIndexOrThrow("address_type");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Home> _result = new ArrayList<Home>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Home _item;
        _item = new Home();
        final String _tmpAddressType;
        _tmpAddressType = _cursor.getString(_cursorIndexOfAddressType);
        _item.setAddressType(_tmpAddressType);
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
