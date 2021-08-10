package com.tw.ch.lcc.hankchan.musicdemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Map;

public class Sound {

    MediaPlayer music;
    SoundPool soundPool;
    Context context;
    int[] sourceid = {R.raw.music831};
    Map<Integer,Integer> soundMap;

    public Sound(Context context){
        this.context = context;
        initMusic();
        initSound();
    }

    public void initSound(){
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,5);
        soundMap  = new HashMap<Integer,Integer>();
        soundMap.put(sourceid[0],soundPool.load(context,sourceid[0],1));
        soundMap.put(sourceid[0],soundPool.load(context,sourceid[0],1));

    }

    public void initMusic(){
        music = MediaPlayer.create(context,sourceid[0]);
        music.setLooping(true);
    }
    // 撥放音效
    public void playSound(int resId){
        Integer sId = soundMap.get(resId);
        if (sId != null)
            soundPool.play(sId,1,1,1,0,1);
    }

    public void setmusicStatus(boolean status){
        if(status)
            music.start();
        else
            music.stop();
    }

    public void release(){
        music.release();
        soundPool.release();
        soundMap.clear();
    }


}
