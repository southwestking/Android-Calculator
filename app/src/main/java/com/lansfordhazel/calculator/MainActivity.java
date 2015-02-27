package com.lansfordhazel.calculator;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        EditText eText;
        View rootView;
        TextView ans;
        ArrayList<String> memory = new ArrayList<>();
        double lastResult;
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);

            //Buttons on normal calculator screen
            Button btn0 = (Button) rootView.findViewById(R.id.btn0);
            Button btn1 = (Button) rootView.findViewById(R.id.btn1);
            Button btn2 = (Button) rootView.findViewById(R.id.btn2);
            Button btn3 = (Button) rootView.findViewById(R.id.btn3);
            Button btn4 = (Button) rootView.findViewById(R.id.btn4);
            Button btn5 = (Button) rootView.findViewById(R.id.btn5);
            Button btn6 = (Button) rootView.findViewById(R.id.btn6);
            Button btn7 = (Button) rootView.findViewById(R.id.btn7);
            Button btn8 = (Button) rootView.findViewById(R.id.btn8);
            Button btn9 = (Button) rootView.findViewById(R.id.btn9);
            Button btnBack = (Button) rootView.findViewById(R.id.btnBack);
            Button btnPlus = (Button) rootView.findViewById(R.id.btnAddition);
            Button btnMinus = (Button) rootView.findViewById(R.id.btnSubtract);
            Button btnEqual = (Button) rootView.findViewById(R.id.btnEqual);
            Button btnClear = (Button) rootView.findViewById(R.id.btnClear);
            Button btnMultiply = (Button) rootView.findViewById(R.id.btnx);
            eText = (EditText) rootView.findViewById(R.id.screen);
            ans = (TextView) rootView.findViewById(R.id.ans);
            //sets action listeners on button
            btn0.setOnClickListener(this);
            btn1.setOnClickListener(this);
            btn2.setOnClickListener(this);
            btn3.setOnClickListener(this);
            btn4.setOnClickListener(this);
            btn5.setOnClickListener(this);
            btn6.setOnClickListener(this);
            btn7.setOnClickListener(this);
            btn8.setOnClickListener(this);
            btn9.setOnClickListener(this);
            btnBack.setOnClickListener(this);
            btnPlus.setOnClickListener(this);
            btnMinus.setOnClickListener(this);
            btnEqual.setOnClickListener(this);
            btnClear.setOnClickListener(this);
            btnMultiply.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }

        @Override
        public void onClick(View v) {
            //button controls
            switch(v.getId()){
                case R.id.btn0:
                    addValueToScreen("0");
                    break;

                case R.id.btn1:
                    addValueToScreen("1");
                    break;

                case R.id.btn2:
                    addValueToScreen("2");
                    break;

                case R.id.btn3:
                    addValueToScreen("3");
                    break;

                case R.id.btn4:
                    addValueToScreen("4");
                    break;

                case R.id.btn5:
                    addValueToScreen("5");
                    break;

                case R.id.btn6:
                    addValueToScreen("6");
                    break;

                case R.id.btn7:
                    addValueToScreen("7");
                    break;

                case R.id.btn8:
                    addValueToScreen("8");
                    break;

                case R.id.btn9:
                    addValueToScreen("9");
                    break;

                case R.id.btnAns:
                    addValueToScreen("Ans");
                    break;

                case R.id.btnx:
                    multiply();
                    break;

                case R.id.btnBack:
                    addRemoveLast();
                    break;

                case R.id.btnAddition:
                    addition();
                    break;

                case R.id.btnSubtract:
                    subtract();
                    break;

                case R.id.btnClear:
                    clear();
                    break;
            }
        }

        public void addValueToScreen(String insert){

            Log.i("Method:addValueToScreen", "Value:" + insert);
            if(getString().equals("0") || getLength() == 0) {
                Log.i("Method:addValueToScreen", "getString() == '0' ||  getLength() == '0'");
                eText.setText(insert);
            }
            else{
                eText.setText(eText.getText().toString() + insert);
            }
        }

        public void addRemoveLast(){

            Log.i("Method: addRemoveLast","getLength() > 0");
            if(getLength() > 1) {
                Log.i("Method: addRemoveLast","");
                eText.setText(eText.getText().toString().substring(0, getLength() - 1));
            }
            else if(getLength() == 0 || getLength() == 1){
                Log.i("Method: addRemoveLast","getLength() == 0");
                eText.setText("0");
            }
        }

        public int getLength(){
            //need to check for dot
            return eText.getText().toString().length();
        }

        public void multiply(){
            Log.i("Method: multiply()","");
            String[] str = ansString().split(" ");

            if (ans.getText().length() == 0) {
                ans.setText(getString() + " x");
                memory.add(getString());
                eText.setText("0");

            }
            else if(str.length == 1){

                // switch(str[1])
                //   case ""

            }
            else if(!getString().equals("0")){
                int primary = Integer.parseInt(str[0]);
                int tempAnswer = 0;
                switch (str[1]){
                    case "+":
                        Log.i("Method: multiply()", "+");
                        tempAnswer = primary + getInt();
                        ans.setText(tempAnswer + " x");
                        clearScreen();
                        break;
                    case "-":
                        Log.i("Method: multiply()", "-");
                        tempAnswer = primary - getInt();
                        ans.setText(tempAnswer + " x");
                        clearScreen();
                        break;
                    case "x":
                        Log.i("Method: multiply()", "x");
                        tempAnswer = primary * getInt();
                        ans.setText(tempAnswer + " x");
                        clearScreen();
                        break;
                }
            }
        }

        public void addition(){
            Log.i("Method: addition()", "");
            String[] str = ansString().split(" ");

                if (ans.getText().length() == 0) {
                    ans.setText(getString() + " +");
                    memory.add(getString());
                    eText.setText("0");

                }
                else if(str.length == 1){

                        // switch(str[1])
                        //   case ""

                }
                else if(!getString().equals("0")){
                    int primary = Integer.parseInt(str[0]);
                    int tempAnswer = 0;
                    switch (str[1]){
                        case "+":
                            Log.i("Method: addition()", "+");
                            tempAnswer = primary + getInt();
                            ans.setText(tempAnswer + " +");
                            clearScreen();
                            break;
                        case "-":
                            Log.i("Method: addition()", "-");
                            tempAnswer = primary - getInt();
                            ans.setText(tempAnswer + " +");
                            clearScreen();
                            break;
                        case "x":
                            Log.i("Method: addition()", "x");
                            tempAnswer = primary * getInt();
                            ans.setText(tempAnswer + " +");
                            clearScreen();
                            break;
                    }
                }
        }

        public void subtract(){
            Log.i("Method: subtract()", "");
            String[] str = ansString().split(" ");

            if (ans.getText().length() == 0) {
                ans.setText(getString() + " -");
                memory.add(getString());
                eText.setText("0");

            }
            else if(str.length == 1){

                // switch(str[1])
                //   case ""

            }
            else if(!getString().equals("0")){
                int primary = Integer.parseInt(str[0]);
                int tempAnswer = 0;
                switch (str[1]){
                    case "+":
                        Log.i("Method: subtract()", "+");
                        tempAnswer = primary + getInt();
                        ans.setText(tempAnswer + " -");
                        clearScreen();
                        break;
                    case "-":
                        Log.i("Method: subtract()", "-");
                        tempAnswer = primary - getInt();
                        ans.setText(tempAnswer + " -");
                        clearScreen();
                        break;
                    case "x":
                        Log.i("Method: subtract()", "x");
                        tempAnswer = primary * getInt();
                        ans.setText(tempAnswer + " -");
                        clearScreen();
                        break;
                }
            }
        }

        public void clear(){
            Log.i("Method: clear()","");
            eText.setText("0");
            memory.clear();
            ans.setText("");
        }
        public void clearScreen(){
            Log.i("Method: clearScreen()","");
            eText.setText("0");
        }


        public void Solve(){
            double answer = 0;
            Log.i("Method: Solve()","");
            for(String x: memory){
                if(x == "Ans"){

                }
                else{
                    answer += Integer.parseInt(x);
                }
            }
            eText.setText(answer+"");
            memory.clear();
        }
        private String getString(){
            return eText.getText().toString();
        }
        private int ansLength(){
            return ans.getText().toString().length();
        }
        private String ansString(){
            return ans.getText().toString();
        }

        private int getInt(){
            return Integer.parseInt(eText.getText().toString());
        }

    }

}
