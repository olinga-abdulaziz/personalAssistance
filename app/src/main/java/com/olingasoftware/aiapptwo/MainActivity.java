package com.olingasoftware.aiapptwo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech textToSpeech;
    private SpeechRecognizer speechRecognizer;
    private TextView me;
    private TextView oling;
    private Intent intent;
    private ImageView mic;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{RECORD_AUDIO, WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        me=findViewById(R.id.me);
        oling=findViewById(R.id.oling);
        mic=findViewById(R.id.mic);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMicClicked();
            }
        });
        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                startSpeek();
            }
        });
        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        String olingRep=oling.getText().toString();
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches=results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                String string="";
                me.setText("");
                if (matches !=null){
                    string=matches.get(0);
                    me.setText(string);
                    if (string.equals("I'm fine")||string.equals("I'm ok")||string.equals("yes I'm fine")||string.equals("yeah")||string.equals("yeah sure")||string.equals(" yeah I'm fine")||string.equals("yes")||string.equals("fine")||string.equals("good")||string.equals("I'm good")||string.equals("I am fine")||string.equals("I am good")){
                        oling.setText("ok,what should i do for you");
                        textToSpeech.speak("ok,what should i do for you",TextToSpeech.QUEUE_ADD,null,null);
                        step2();
                        }else  if (string.equals("I'm not fine")||string.equals("not fine")||string.equals("not good")||string.equals("I'm not good")||string.equals("I am not fine")||string.equals("I am not good")) {
                        oling.setText("why are you not fine");
                        textToSpeech.speak("why are you not fine",TextToSpeech.QUEUE_ADD,null,null);
                    }else {
                        oling.setText("Sorry i did not understand");
                        textToSpeech.speak("Sorry i did not understand",TextToSpeech.QUEUE_ADD,null,null);
                        textToSpeech.speak("Are you fine ",TextToSpeech.QUEUE_ADD,null,null);
                    }
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });



    }

    private void step2() {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches=results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                String string="";
                me.setText("");
                if (matches !=null){
                    string=matches.get(0);
                    me.setText(string);
                    if (string.equals("who are you")||string.equals("what is your name")){
                        oling.setText("My name is professor Abdulaziz");
                        textToSpeech.speak("My name is professor Abdulaziz",TextToSpeech.QUEUE_ADD,null,null);
                        textToSpeech.speak("What about you",TextToSpeech.QUEUE_ADD,null,null);
                        step3();
                    }}
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });

    }

    private void step3() {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizer=SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches=results.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                String string="";
                me.setText("");
                if (matches !=null){
                    string=matches.get(0);
                    me.setText(string);
                    if (string.equals("i dont have a name")){
                        oling.setText("why dont you have a name ");
                        textToSpeech.speak("why dont you have a name",TextToSpeech.QUEUE_ADD,null,null);
                        textToSpeech.speak("how do people call you",TextToSpeech.QUEUE_ADD,null,null);

                    }else {
                        oling.setText("Nice to know you"+matches.get(0));
                        textToSpeech.speak("Nice to know you "+me.getText().toString(),TextToSpeech.QUEUE_ADD,null,null);
                        textToSpeech.speak("you have a nice name",TextToSpeech.QUEUE_ADD,null,null);
                    }
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startSpeek(){
        textToSpeech.speak("Hello,how are you",TextToSpeech.QUEUE_ADD,null,null);
    }
    private void onMicClicked() {
        speechRecognizer.startListening(intent);
    }

}