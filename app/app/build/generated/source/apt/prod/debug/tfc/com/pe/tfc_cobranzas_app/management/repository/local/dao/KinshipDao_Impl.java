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
import tfc.com.pe.tfc_cobranzas_app.management.model.Kinship;

public class KinshipDao_Impl implements KinshipDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfKinship;

  private final SharedSQLiteStatement __preparedStmtOfTruncate;

  public KinshipDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfKinship = new EntityInsertionAdapter<Kinship>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `kinship`(`family_relationship`,`description`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Kinship value) {
        if (value.getFamilyRelationship() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFamilyRelationship());
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
        final String _query = "DELETE FROM kinship";
        return _query;
      }
    };
  }

  @Override
  public void insert(Kinship... kinship) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfKinship.insert(kinship);
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
  public List<Kinship> getAll() {
    final String _sql = "SELECT * FROM kinship";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfFamilyRelationship = _cursor.getColumnIndexOrThrow("family_relationship");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final List<Kinship> _result = new ArrayList<Kinship>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Kinship _item;
        _item = new Kinship();
        final String _tmpFamilyRelationship;
        _tmpFamilyRelationship = _cursor.getString(_cursorIndexOfFamilyRelationship);
        _item.setFamilyRelationship(_tmpFamilyRelationship);
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
