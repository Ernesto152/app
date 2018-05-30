package tfc.com.pe.tfc_cobranzas_app.management.repository.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ComboGenericDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ComboGenericDao_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.HomeDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.HomeDao_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.KinshipDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.KinshipDao_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ManagementDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ManagementDao_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.PhoneDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.PhoneDao_Impl;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ResponseManagementDao;
import tfc.com.pe.tfc_cobranzas_app.management.repository.local.dao.ResponseManagementDao_Impl;

public class ManagementDatabase_Impl extends ManagementDatabase {
  private volatile ManagementDao _managementDao;

  private volatile ResponseManagementDao _responseManagementDao;

  private volatile ComboGenericDao _comboGenericDao;

  private volatile HomeDao _homeDao;

  private volatile PhoneDao _phoneDao;

  private volatile KinshipDao _kinshipDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `management` (`id` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `response_management` (`id` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `combo_generic` (`id` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `home` (`address_type` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`address_type`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `phone` (`phone_type` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`phone_type`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `kinship` (`family_relationship` TEXT NOT NULL, `description` TEXT NOT NULL, PRIMARY KEY(`family_relationship`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"42dd0f7095efc756e42fdeab26e5fc20\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `management`");
        _db.execSQL("DROP TABLE IF EXISTS `response_management`");
        _db.execSQL("DROP TABLE IF EXISTS `combo_generic`");
        _db.execSQL("DROP TABLE IF EXISTS `home`");
        _db.execSQL("DROP TABLE IF EXISTS `phone`");
        _db.execSQL("DROP TABLE IF EXISTS `kinship`");
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
        final HashMap<String, TableInfo.Column> _columnsManagement = new HashMap<String, TableInfo.Column>(2);
        _columnsManagement.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsManagement.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysManagement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesManagement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoManagement = new TableInfo("management", _columnsManagement, _foreignKeysManagement, _indicesManagement);
        final TableInfo _existingManagement = TableInfo.read(_db, "management");
        if (! _infoManagement.equals(_existingManagement)) {
          throw new IllegalStateException("Migration didn't properly handle management(tfc.com.pe.tfc_cobranzas_app.management.model.Management).\n"
                  + " Expected:\n" + _infoManagement + "\n"
                  + " Found:\n" + _existingManagement);
        }
        final HashMap<String, TableInfo.Column> _columnsResponseManagement = new HashMap<String, TableInfo.Column>(2);
        _columnsResponseManagement.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsResponseManagement.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysResponseManagement = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesResponseManagement = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoResponseManagement = new TableInfo("response_management", _columnsResponseManagement, _foreignKeysResponseManagement, _indicesResponseManagement);
        final TableInfo _existingResponseManagement = TableInfo.read(_db, "response_management");
        if (! _infoResponseManagement.equals(_existingResponseManagement)) {
          throw new IllegalStateException("Migration didn't properly handle response_management(tfc.com.pe.tfc_cobranzas_app.management.model.ResponseManagement).\n"
                  + " Expected:\n" + _infoResponseManagement + "\n"
                  + " Found:\n" + _existingResponseManagement);
        }
        final HashMap<String, TableInfo.Column> _columnsComboGeneric = new HashMap<String, TableInfo.Column>(2);
        _columnsComboGeneric.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsComboGeneric.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComboGeneric = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComboGeneric = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComboGeneric = new TableInfo("combo_generic", _columnsComboGeneric, _foreignKeysComboGeneric, _indicesComboGeneric);
        final TableInfo _existingComboGeneric = TableInfo.read(_db, "combo_generic");
        if (! _infoComboGeneric.equals(_existingComboGeneric)) {
          throw new IllegalStateException("Migration didn't properly handle combo_generic(tfc.com.pe.tfc_cobranzas_app.management.model.ComboGeneric).\n"
                  + " Expected:\n" + _infoComboGeneric + "\n"
                  + " Found:\n" + _existingComboGeneric);
        }
        final HashMap<String, TableInfo.Column> _columnsHome = new HashMap<String, TableInfo.Column>(2);
        _columnsHome.put("address_type", new TableInfo.Column("address_type", "TEXT", true, 1));
        _columnsHome.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHome = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHome = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHome = new TableInfo("home", _columnsHome, _foreignKeysHome, _indicesHome);
        final TableInfo _existingHome = TableInfo.read(_db, "home");
        if (! _infoHome.equals(_existingHome)) {
          throw new IllegalStateException("Migration didn't properly handle home(tfc.com.pe.tfc_cobranzas_app.management.model.Home).\n"
                  + " Expected:\n" + _infoHome + "\n"
                  + " Found:\n" + _existingHome);
        }
        final HashMap<String, TableInfo.Column> _columnsPhone = new HashMap<String, TableInfo.Column>(2);
        _columnsPhone.put("phone_type", new TableInfo.Column("phone_type", "TEXT", true, 1));
        _columnsPhone.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPhone = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPhone = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPhone = new TableInfo("phone", _columnsPhone, _foreignKeysPhone, _indicesPhone);
        final TableInfo _existingPhone = TableInfo.read(_db, "phone");
        if (! _infoPhone.equals(_existingPhone)) {
          throw new IllegalStateException("Migration didn't properly handle phone(tfc.com.pe.tfc_cobranzas_app.management.model.Phone).\n"
                  + " Expected:\n" + _infoPhone + "\n"
                  + " Found:\n" + _existingPhone);
        }
        final HashMap<String, TableInfo.Column> _columnsKinship = new HashMap<String, TableInfo.Column>(2);
        _columnsKinship.put("family_relationship", new TableInfo.Column("family_relationship", "TEXT", true, 1));
        _columnsKinship.put("description", new TableInfo.Column("description", "TEXT", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysKinship = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesKinship = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoKinship = new TableInfo("kinship", _columnsKinship, _foreignKeysKinship, _indicesKinship);
        final TableInfo _existingKinship = TableInfo.read(_db, "kinship");
        if (! _infoKinship.equals(_existingKinship)) {
          throw new IllegalStateException("Migration didn't properly handle kinship(tfc.com.pe.tfc_cobranzas_app.management.model.Kinship).\n"
                  + " Expected:\n" + _infoKinship + "\n"
                  + " Found:\n" + _existingKinship);
        }
      }
    }, "42dd0f7095efc756e42fdeab26e5fc20");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "management","response_management","combo_generic","home","phone","kinship");
  }

  @Override
  public ManagementDao managementDao() {
    if (_managementDao != null) {
      return _managementDao;
    } else {
      synchronized(this) {
        if(_managementDao == null) {
          _managementDao = new ManagementDao_Impl(this);
        }
        return _managementDao;
      }
    }
  }

  @Override
  public ResponseManagementDao responseManagementDao() {
    if (_responseManagementDao != null) {
      return _responseManagementDao;
    } else {
      synchronized(this) {
        if(_responseManagementDao == null) {
          _responseManagementDao = new ResponseManagementDao_Impl(this);
        }
        return _responseManagementDao;
      }
    }
  }

  @Override
  public ComboGenericDao comboGenericDao() {
    if (_comboGenericDao != null) {
      return _comboGenericDao;
    } else {
      synchronized(this) {
        if(_comboGenericDao == null) {
          _comboGenericDao = new ComboGenericDao_Impl(this);
        }
        return _comboGenericDao;
      }
    }
  }

  @Override
  public HomeDao homeDao() {
    if (_homeDao != null) {
      return _homeDao;
    } else {
      synchronized(this) {
        if(_homeDao == null) {
          _homeDao = new HomeDao_Impl(this);
        }
        return _homeDao;
      }
    }
  }

  @Override
  public PhoneDao phoneDao() {
    if (_phoneDao != null) {
      return _phoneDao;
    } else {
      synchronized(this) {
        if(_phoneDao == null) {
          _phoneDao = new PhoneDao_Impl(this);
        }
        return _phoneDao;
      }
    }
  }

  @Override
  public KinshipDao kinshipDao() {
    if (_kinshipDao != null) {
      return _kinshipDao;
    } else {
      synchronized(this) {
        if(_kinshipDao == null) {
          _kinshipDao = new KinshipDao_Impl(this);
        }
        return _kinshipDao;
      }
    }
  }
}
