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
import tfc.com.pe.tfc_cobranzas_app.management.model.Management;

public class ManagementDao_Impl implements ManagementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfManagement;

  private final SharedSQLiteStatement __preparedStmtOfTruncate;

  public ManagementDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfManagement = new EntityInsertionAdapter<Management>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `management`(`id`,`description`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Management value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
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
        final String _query = "DELETE FROM management";
        return _query;
      }
    };
  }

  @Override
  public void insert(Management... managements) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfManagement.insert(managements);
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
  public List<Management> getAll() {
    final String _sql = "SELECT * FROM management ORDER BY id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Management> _result = new ArrayList<Management>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Management _item;
        _item = new Management();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
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
