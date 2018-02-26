package mrkappdevelopers.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper{

    private Context context;

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "Student";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";

    private static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NAME + " VARCHAR(50), "
            + AGE + " INTEGER), "
            + GENDER + " VARCHAR(10));";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;

    private static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(CREATE_TABLE);
        }
        catch (Exception e){
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
        catch (Exception e){
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_SHORT).show();
        }

    }
}
