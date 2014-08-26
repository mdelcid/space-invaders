package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ListenerI extends ClickListener
{
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		super.touchDown(event, x, y, pointer, button);
		System.out.println("Estoy presionando!");
		MyGdxGame.nave.setX(MyGdxGame.nave.getX()-5);
		return true;
	}
}
