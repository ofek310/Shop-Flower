package com.example.shopflowers;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {
    int numberFlowers = 3;
    int numberExtebsions = 2;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        String costumer_details = getIntent().getStringExtra("string_details_customer");
        TextView textViewCustomerDetails = findViewById(R.id.customer_details);
        textViewCustomerDetails.setText(costumer_details);

        boolean existsExtensions = getIntent().getBooleanExtra("exists_extension",true);

        int sum=0;
        String flowerName[] = {getString(R.string.first_flower),getString(R.string.second_flower),getString(R.string.third_flower)};
        int priceFlower[] ={6,4,5};
        String countWhichFlower[] = getIntent().getStringArrayExtra("string_count");
        String whichExtebsion[] = getIntent().getStringArrayExtra("string_extebsions");
        String Extebsion[] = {getString(R.string.check_box1_wine),getString(R.string.check_box2_ballon)};

        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TableLayout.LayoutParams layoutParamsFirstLine = new TableLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        TableRow.LayoutParams layoutParamsLine = new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsLine.setMarginEnd(25);

        TableLayout tableLayoutScroll = findViewById(R.id.linearLayoutScroll);

        TableRow tableLayoutFirstLine = new TableRow(this);
        tableLayoutFirstLine.setLayoutParams(layoutParamsFirstLine);
        tableLayoutFirstLine.setBackgroundResource(R.drawable.receipt_shape);
        TextView textViewNumberFirstLine = new TextView(this);
        textViewNumberFirstLine.setText(getString(R.string.line_row));
        textViewNumberFirstLine.setLayoutParams(layoutParamsLine);
        TextView textViewNameFirstLine = new TextView(this);
        textViewNameFirstLine.setText(getString(R.string.name_flower_row));
        textViewNameFirstLine.setLayoutParams(layoutParamsLine);
        TextView textViewCountFirstLine = new TextView(this);
        textViewCountFirstLine.setText(R.string.count_row);
        textViewCountFirstLine.setLayoutParams(layoutParamsLine);
        TextView textViewPriceFirstLine = new TextView(this);
        textViewPriceFirstLine.setText(R.string.price_flower_row);
        textViewPriceFirstLine.setLayoutParams(layoutParamsLine);
        tableLayoutFirstLine.addView(textViewNumberFirstLine);
        tableLayoutFirstLine.addView(textViewNameFirstLine);
        tableLayoutFirstLine.addView(textViewCountFirstLine);
        tableLayoutFirstLine.addView(textViewPriceFirstLine);
        tableLayoutScroll.addView(tableLayoutFirstLine);
        for (int i = 0; i < numberFlowers; i++) {
            int numberWhichFlowers = Integer.parseInt(countWhichFlower[i]);
            sum = sum +numberWhichFlowers*priceFlower[i];
            for(int j=0;j<numberWhichFlowers;j++){
                TableRow tableLayoutLine = new TableRow(this);
                tableLayoutLine.setLayoutParams(layoutParamsFirstLine);
                TextView textViewNumber = new TextView(this);
                textViewNumber.setText((j+1)+"");
                textViewNumber.setLayoutParams(layoutParams);
                TextView textViewCount = new TextView(this);
                textViewCount.setText("1");
                textViewCount.setLayoutParams(layoutParams);
                TextView textViewName = new TextView(this);
                textViewName.setText(flowerName[i]);
                textViewName.setLayoutParams(layoutParams);
                TextView textViewPrice = new TextView(this);
                textViewPrice.setText(priceFlower[i]+" "+getString(R.string.nis_name));
                textViewPrice.setLayoutParams(layoutParams);
                tableLayoutLine.addView(textViewNumber);
                tableLayoutLine.addView(textViewName);
                tableLayoutLine.addView(textViewCount);
                tableLayoutLine.addView(textViewPrice);
                tableLayoutScroll.addView(tableLayoutLine);
            }
        }

        if(existsExtensions) {
            TextView textViewEnd = findViewById(R.id.title_extention);
            textViewEnd.setText(R.string.extensions_name);

            TableLayout tableLayoutExtebsions = findViewById(R.id.layout_extebsions);

            TableRow tableLayoutExtebsionsFirstLine = new TableRow(this);
            tableLayoutExtebsionsFirstLine.setLayoutParams(layoutParamsFirstLine);
            tableLayoutExtebsionsFirstLine.setBackgroundResource(R.drawable.receipt_shape);
            TextView textViewExtebsionsFirstLine = new TextView(this);
            textViewExtebsionsFirstLine.setText(getString(R.string.extensions_row));
            textViewExtebsionsFirstLine.setLayoutParams(layoutParamsLine);
            TextView textViewExtebsionsKindFirstLine = new TextView(this);
            textViewExtebsionsKindFirstLine.setText(getString(R.string.extensions_kind_row));
            textViewExtebsionsKindFirstLine.setLayoutParams(layoutParamsLine);
            TextView textViewExtebsionsPriceFirstLine = new TextView(this);
            textViewExtebsionsPriceFirstLine.setText(getString(R.string.extensions_price_row));
            textViewExtebsionsPriceFirstLine.setLayoutParams(layoutParamsLine);
            tableLayoutExtebsionsFirstLine.addView(textViewExtebsionsFirstLine);
            tableLayoutExtebsionsFirstLine.addView(textViewExtebsionsKindFirstLine);
            tableLayoutExtebsionsFirstLine.addView(textViewExtebsionsPriceFirstLine);
            tableLayoutExtebsions.addView(tableLayoutExtebsionsFirstLine);
            for (int n = 0; n < numberExtebsions; n++) {
                if (!(whichExtebsion[n].matches(""))) {
                    sum = sum + 20;
                    TableRow tableLayoutExtebsionsLine = new TableRow(this);
                    tableLayoutExtebsionsLine.setLayoutParams(layoutParamsFirstLine);
                    TextView textViewExtebsions = new TextView(this);
                    textViewExtebsions.setText(Extebsion[n]);
                    textViewExtebsions.setLayoutParams(layoutParams);
                    TextView textViewKindExtebsions = new TextView(this);
                    textViewKindExtebsions.setText(whichExtebsion[n]);
                    textViewKindExtebsions.setLayoutParams(layoutParams);
                    TextView textViewPriceExtebsions = new TextView(this);
                    textViewPriceExtebsions.setText("20 " + getString(R.string.nis_name));
                    textViewPriceExtebsions.setLayoutParams(layoutParams);
                    tableLayoutExtebsionsLine.addView(textViewExtebsions);
                    tableLayoutExtebsionsLine.addView(textViewKindExtebsions);
                    tableLayoutExtebsionsLine.addView(textViewPriceExtebsions);
                    tableLayoutExtebsions.addView(tableLayoutExtebsionsLine);
                }
            }
        }
        TextView textViewSum = findViewById(R.id.sum);
        textViewSum.setText(sum + " " + getString(R.string.nis_name));
    }
}
