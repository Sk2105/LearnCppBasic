package com.sgtech.learncppbasic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.vungle.warren.AdConfig;
import com.vungle.warren.Banners;
import com.vungle.warren.InitCallback;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<DataHolder> list;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    LinearLayout adview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        addList();
        adview = findViewById(R.id.adView);
        recyclerView = findViewById(R.id.recycler);
        adapter = new RecyclerAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Vungle.init("633af9342b028cfda77c7e28", getApplicationContext(), new InitCallback() {
            @Override
            public void onSuccess() {
                loadAd();
            }

            @Override
            public void onError(VungleException exception) {

            }

            @Override
            public void onAutoCacheAdAvailable(String placementId) {

            }
        });


    }

    private void loadAd() {
        Banners.loadBanner("BANNERAD-9356735", AdConfig.AdSize.BANNER, new LoadAdCallback() {
            @Override
            public void onAdLoad(String placementId) {
                if (Banners.canPlayAd("BANNERAD-9356735", AdConfig.AdSize.BANNER)) {
                    adview.addView(Banners.getBanner("BANNERAD-9356735", AdConfig.AdSize.BANNER, null));
                }
            }

            @Override
            public void onError(String placementId, VungleException exception) {

            }
        });
    }

    public void addList() {
        list.add(new DataHolder(getString(R.string.cpp_introduction), "cpp_intro.asp"));
        list.add(new DataHolder(getString(R.string.cpp_syntax), "cpp_syntax.asp"));
        list.add(new DataHolder(getString(R.string.cpp_output1), "cpp_output.asp"));
        list.add(new DataHolder(getString(R.string.cpp_output2), "cpp_new_lines.asp"));
        list.add(new DataHolder(getString(R.string.cpp_comment), "cpp_comments.asp"));
        list.add(new DataHolder(getString(R.string.cpp_variables), "cpp_variables.asp"));
        list.add(new DataHolder(getString(R.string.cpp_variables_multiple_variables), "cpp_variables_multiple.asp"));
        list.add(new DataHolder(getString(R.string.cpp_variables_identifiers), "cpp_variables_identifiers.asp"));
        list.add(new DataHolder(getString(R.string.cpp_variables_constants), "cpp_variables_constants.asp"));
        list.add(new DataHolder(getString(R.string.cpp_user_input), "cpp_user_input.asp"));
        list.add(new DataHolder(getString(R.string.cpp_basic_data_types), "cpp_data_types.asp"));
        list.add(new DataHolder(getString(R.string.cpp_numeric_data_types), "cpp_data_types_numeric.asp"));
        list.add(new DataHolder(getString(R.string.cpp_boolean_data_types), "cpp_data_types_bool.asp"));
        list.add(new DataHolder(getString(R.string.cpp_character_data_types), "cpp_data_types_char.asp"));
        list.add(new DataHolder(getString(R.string.cpp_string_data_types), "cpp_data_types_string.asp"));
        list.add(new DataHolder(getString(R.string.cpp_arithmetic_operators), "cpp_operators.asp"));
        list.add(new DataHolder(getString(R.string.cpp_assignment_operators), "cpp_operators_assignment.asp"));
        list.add(new DataHolder(getString(R.string.cpp_comparison_operators), "cpp_operators_comparison.asp"));
        list.add(new DataHolder(getString(R.string.cpp_logical_operators), "cpp_operators_logical.asp"));
        list.add(new DataHolder(getString(R.string.cpp_string_concatenation), "cpp_strings_concat.asp"));
        list.add(new DataHolder(getString(R.string.cpp_string), "cpp_strings.asp"));
        list.add(new DataHolder(getString(R.string.cpp_number_and_string), "cpp_strings_numbers.asp"));
        list.add(new DataHolder(getString(R.string.cpp_string_length), "cpp_strings_length.asp"));
        list.add(new DataHolder(getString(R.string.cpp_access_string), "cpp_strings_access.asp"));
        list.add(new DataHolder(getString(R.string.cpp_special_characters), "cpp_strings_esc.asp"));
        list.add(new DataHolder(getString(R.string.cpp_user_input_string), "cpp_strings_input.asp"));
        list.add(new DataHolder(getString(R.string.cpp_string_namespace), "cpp_strings_namespace.asp"));
        list.add(new DataHolder(getString(R.string.cpp_math), "cpp_math.asp"));
        list.add(new DataHolder(getString(R.string.cpp_boolean), "cpp_booleans.asp"));
        list.add(new DataHolder(getString(R.string.cpp_boolean_expressions), "cpp_booleans_expressions.asp"));
        list.add(new DataHolder(getString(R.string.cpp_if_else), "cpp_conditions.asp"));
        list.add(new DataHolder(getString(R.string.cpp_else), "cpp_conditions_else.asp"));
        list.add(new DataHolder(getString(R.string.cpp_else_if), "cpp_conditions_elseif.asp"));
        list.add(new DataHolder(getString(R.string.cpp_Short_Hand_else_if), "cpp_conditions_shorthand.asp"));
        list.add(new DataHolder(getString(R.string.cpp_switch), "cpp_switch.asp"));
        list.add(new DataHolder(getString(R.string.cpp_while_loop), "cpp_while_loop.asp"));
        list.add(new DataHolder(getString(R.string.cpp_do_while_loop), "cpp_do_while_loop.asp"));
        list.add(new DataHolder(getString(R.string.cpp_while_loop), "cpp_for_loop.asp"));
        list.add(new DataHolder(getString(R.string.cpp_break_continue), "cpp_break.asp"));
        list.add(new DataHolder(getString(R.string.cpp_array), "cpp_arrays.asp"));
        list.add(new DataHolder(getString(R.string.cpp_array_and_loops), "cpp_arrays_loop.asp"));
        list.add(new DataHolder(getString(R.string.cpp_omit_array_array_size), "cpp_arrays_omit.asp"));
        list.add(new DataHolder(getString(R.string.cpp_get_array_size), "cpp_arrays_size.asp"));
        list.add(new DataHolder(getString(R.string.cpp_multi_dimensional_array), "cpp_arrays_multi.asp"));
        list.add(new DataHolder(getString(R.string.cpp_structures), "cpp_structs.asp"));
        list.add(new DataHolder(getString(R.string.cpp_references), "cpp_references.asp"));
        list.add(new DataHolder(getString(R.string.cpp_memory_address), "cpp_references_memory.asp"));
        list.add(new DataHolder(getString(R.string.cpp_pointers), "cpp_pointers.asp"));
        list.add(new DataHolder(getString(R.string.cpp_Dereference), "cpp_pointers_dereference.asp"));
        list.add(new DataHolder(getString(R.string.cpp_modify_pointers), "cpp_pointers_modify.asp"));
    }


}