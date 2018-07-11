package com.example.aldres.lifeisrpg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Aldres on 21.06.2018.
 */

public class ProfileFragment extends Fragment {

    @BindView(R.id.user_avatar)
    ImageView avatarView;
    @BindView(R.id.exp_left)
    TextView expLeft;
    @BindView(R.id.levelBar)
    ProgressBar levelBar;
    @BindView(R.id.current_level)
    TextView currentLevel;
    @BindView(R.id.profile_username)
    TextView username;

    private DBtools tools;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        tools = new DBtools();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setProgressBar();
    }

    private void setProgressBar(){
        tools.initDb().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                int level = user.getLevel();
                int exp = user.getExp();
                currentLevel.setText(new StringBuilder().append("LEVEL ").append(level).toString());

                if (isReadyToLevelUp(exp, level)) {
                    user.addLevel();
                    user.setExp(exp - 1000*level);
                    tools.initDb().setValue(user);
                }
                expLeft.setText(new StringBuilder().append(user.getExp()).append("/").append(1000 * user.getLevel()).toString());
                levelBar.setMax(1000*user.getLevel());
                levelBar.setProgress(user.getExp());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private boolean isReadyToLevelUp(int exp, int level){
        return exp >= 1000 * level;
    }


}
