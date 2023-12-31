package com.rocketracer.game.audioSystem;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class AudioSystem {
    // Attributes
    ImageButton soundButton;
    Music music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));


    // Constructors
    public AudioSystem(final SoundEntity soundEntity){
        soundButton = new ImageButton(soundEntity.getSound(), soundEntity.getMute(), soundEntity.getMute());
        soundButton.setSize(25,25);
        soundButton.setPosition(0, 0);

        //Start and loop music
        music.play();
        music.setLooping(true);

        //Mutes and sends change to soundEntity
        soundButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(music.isPlaying()){
                    music.stop();
                }
                else{
                    music.play();
                }
                soundEntity.setSoundEnabled(!soundEntity.getSoundEnabled());
            }
        });
    }

    // Method
    public ImageButton getSoundButton(){
        return soundButton;
    }
}
