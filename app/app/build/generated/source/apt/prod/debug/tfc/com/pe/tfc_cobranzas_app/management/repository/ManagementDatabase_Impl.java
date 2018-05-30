package tfc.com.pe.tfc_cobranzas_app.management.repository;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.util.TableInfo;

import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

import tfc.com.pe.tfc_cobranzas_app.management.repository.local.HomeEntity_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.ManagementDatabase;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.entity.HomeEntity;

public class ManagementDatabase_Impl extends ManagementDatabase {
  private volatile HomeEntity _homeEntity;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `address` (`address_type` TEXT NOT NULL, `description` TEXT, PRIMARY KEY(`address_type`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"7e8a793038f1ab85896308ab16d442e5\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `address`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAddress = new HashMap<String, TableInfo.Column>(2);
        _columnsAddress.put("address_type", new TableInfo.Column("address_type", "TEXT", true, 1));
        _columnsAddress.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddress = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddress = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddress = new TableInfo("address", _columnsAddress, _foreignKeysAddress, _indicesAddress);
        final TableInfo _existingAddress = TableInfo.read(_db, "address");
        if (! _infoAddress.equals(_existingAddress)) {
          throw new IllegalStateException("Migration didn't properly handle address(tfc.com.pe.tfc_cobranzas_app.management.repository.local.Home).\n"
                  + " Expected:\n" + _infoAddress + "\n"
                  + " Found:\n" + _existingAddress);
        }
      }
    }, "7e8a793038f1ab85896308ab16d442e5");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "address");
  }

  @Override
  public HomeEntity addressDao() {
    if (_homeEntity != null) {
      return _homeEntity;
    } else {
      synchronized(this) {
        if(_homeEntity == null) {
          _homeEntity = new HomeEntity_Impl(this);
        }
        return _homeEntity;
      }
    }
  }
}
