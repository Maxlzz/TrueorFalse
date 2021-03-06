package com.test.max.exam1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GeoQuo extends Activity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private  Button mPreButton;
    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans,true),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_africa,false),
            new TrueFalse(R.string.question_america,true),
            new TrueFalse(R.string.question_asia,true)
    };
    private int mCurrentIndex = 0;
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId=0;
        if (userPressedTrue==answerIsTrue){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_quo);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
//        int question = mQuestionBank[mCurrentIndex].getQuestion();
//        mQuestionTextView.setText(question);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();

            }

        });
          updateQuestion();

        mFalseButton= (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(GeoQuo.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
            checkAnswer(false);
            }
        });
        mTrueButton= (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(GeoQuo.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            checkAnswer(true);
            }
        });
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getQuestion();
//                mQuestionTextView.setText(question);
                updateQuestion();
           }
        });
        mPreButton = (Button) findViewById(R.id.pre_button);
        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCurrentIndex==0){
                    mCurrentIndex = mQuestionBank.length -1;
                }else {
                    mCurrentIndex = (mCurrentIndex-1);
                    updateQuestion();
                }

            }
        });
    }


}
