package com.example.user.orderingcoffee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    private EditText editText;
    private CheckBox whipped,chocolate;
    private TextView quantity_text,summary;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.EditText);
        whipped = (CheckBox) findViewById(R.id.Whipped);
        chocolate = (CheckBox) findViewById(R.id.Chocolate);
        quantity_text = (TextView) findViewById(R.id.quantity_text);
        summary = (TextView) findViewById(R.id.summary_text);
        button = (Button)findViewById(R.id.order_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitOrder(view);
            }
        });

    }

    public void increment(View view){
        if(quantity == 100) return;

        quantity ++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if(quantity == 0) return;

        quantity--;
        displayQuantity(quantity);
    }

    public void submitOrder(View view){
        String name = editText.getText().toString();

        boolean hasWripped = whipped.isChecked();
        boolean hasChocolate = chocolate.isChecked();

        int price = calculateprice(hasWripped,hasChocolate);

        String message = createOrderSummary(name,price,hasWripped,hasChocolate);
        summary.setText(message);
    }

    private int calculateprice(boolean addWripped,boolean addChocolate){

        int basePrice = 10;

        if(addWripped ){
            basePrice += 2;
        }
        if(addChocolate){
            basePrice += 3;
        }
        return quantity*basePrice;
    }

    private String createOrderSummary(String name,int price,boolean hasWripped,boolean hasChocolate){

        String priceMessage = "Name : "+name+"\nAdd whipped cream? : "+hasWripped+"\nAdd Chocolate? : "
                +hasChocolate+"\nTotal : "+price+"$\n\n\n                   Thank You!!!!";

        return priceMessage;

    }

    public void displayQuantity(int nocoffee){
        quantity_text.setText(" "+nocoffee);
    }
}
