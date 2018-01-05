package tw.com.shiaoshia.ex2018010501;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean[] chk = new boolean[5];
    int tmp=-1;
    int ok=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void click01(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("This is Title");
        builder.setMessage("Hello World!!");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按了確認按鈕",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按了取消按鈕",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("HELP", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"按下了HELP按鈕",Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    public void click02(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("對話框");
        final EditText et = new EditText(MainActivity.this);
        final TextView tv = (TextView)findViewById(R.id.textView);
        builder.setView(et);
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下確認",Toast.LENGTH_SHORT).show();
                tv.setText(et.getText().toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(MainActivity.this,"按下了取消",Toast.LENGTH_SHORT).show();
                tv.setText("沒輸入資料");
            }
        });
        builder.show();
    }

    public void click03(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("列表型對話框");
        final String[] fruits = {"香蕉","蘋果","芭樂"};
        final TextView tv02 = (TextView)findViewById(R.id.textView2);
        builder.setItems(fruits, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv02.setText(fruits[i]);
            }
        });
        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false); //只有在AlertDialog畫面內才有作用
        builder.show();
    }

    public void click04(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("單選項型對話框");
        final String fruits[] = {"香蕉","蘋果","梨子"};
        final TextView tv03 = (TextView)findViewById(R.id.textView3);
        tmp = ok;
        builder.setSingleChoiceItems(fruits, ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tmp = i;
            }
        });
        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ok = tmp;
                tv03.setText(fruits[ok]);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();

    }

    public void click05(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("多選列表");
        final String fruits[] = {"蘋果","香蕉","梨子","芭樂","草莓"};
        final TextView tv04 = (TextView)findViewById(R.id.textView4);

        builder.setMultiChoiceItems(fruits, chk, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });

        builder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<=4;j++) {
                    if(chk[j]) {
                        sb.append(fruits[j] + ",");
                    }
                }
                tv04.setText(sb.toString());
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

}
