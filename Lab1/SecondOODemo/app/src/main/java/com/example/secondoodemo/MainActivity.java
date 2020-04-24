package com.example.secondoodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Person> team = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.printTeamButton).setOnClickListener(this);
        findViewById(R.id.addButton).setOnClickListener(this);

        // Person class is abstract, we can not create objects of it.
/*      Person seppo = new Person();
        seppo.setName("Seppo");
        seppo.setSocialSecurityNumber("112233-4567");

        seppo.greet();

        Person ismo = new Person();
        ismo.setName("Ismo Taalasmaa");
        ismo.setSocialSecurityNumber("112233-4567");
*/

        Player maradonna = new Player();
        maradonna.setPlayerNr(23);
        maradonna.setName("Maradonna");

        team.add(maradonna);

        Referee kari = new Referee();
        kari.setWhistleSensitivity("Sensitive");
        kari.setName("Kari Taalasmaa");

        team.add(kari);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.printTeamButton) {
            TextView textView = findViewById(R.id.textView);
            textView.setText("");
            textView.append("Team:\n");
            for (int i = 0; i < team.size(); i++) {
                Person dude = team.get(i);
                textView.append(dude.greet() + "\n");
            }
        }
        else if (v.getId() == R.id.addButton) {
            Player player = new Player();
            EditText editText = findViewById(R.id.editor);
            player.setName(editText.getText().toString());
            team.add(player);
        }
    }
}
