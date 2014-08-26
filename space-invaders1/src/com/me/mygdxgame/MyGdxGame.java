package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//fondo sacado de http://opengameart.org/content/space-background-2
public class MyGdxGame implements ApplicationListener 
{	
	private Texture texture;
	Stage stage;
	Stage stage2;
	Image fondo;
	static Image nave;
	Image enemigos1;
	Image enemigos2;
	Image enemigos3;
	static Image proyectil;
	Image derecho;
	Image izquierdo;
	Image image1;
	
	boolean izquierda=false;
	
	int a=1;
	int b=2;
	
	Stage stage1;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
	
		texture = new Texture(Gdx.files.internal("data/nave.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 64, 128);
		
		stage = new Stage();
		
		nave = new Image(region);
		fondo = new Image(new Texture(Gdx.files.internal("data/fondo.png")));
		enemigos1 = new Image(new Texture(Gdx.files.internal("data/enemigos1.png")));
		enemigos2 = new Image(new Texture(Gdx.files.internal("data/enemigos2.png")));
		enemigos3 = new Image(new Texture(Gdx.files.internal("data/enemigos3.png")));
		proyectil = new Image(new Texture(Gdx.files.internal("data/proyectil.png")));
		derecho = new Image(new Texture(Gdx.files.internal("data/derecha.png")));
		izquierdo = new Image(new Texture(Gdx.files.internal("data/izquierda.png")));
		stage1= new Stage();
		nave=new Image(region);
		nave.addListener(new ClickListener());
		nave.setX(400);
		enemigos1.setY(770);
		enemigos2.setY(770);
		enemigos3.setY(770);
		proyectil.setX(416);
		proyectil.setY(50);
		derecho.setX(770);
		derecho.addListener(new ListenerD());
		izquierdo.setX(5);
		izquierdo.addListener(new ListenerI());
		
		
		
		stage.addActor(fondo);
		stage.addActor(proyectil);
		stage.addActor(nave);
		stage.addActor(enemigos1);
		stage.addActor(enemigos2);
		stage.addActor(enemigos3);
		stage.addActor(derecho);
		stage.addActor(izquierdo);
		
		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		texture.dispose();	
	}

	@Override
	public void render() {		
		//Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
	
		if(Gdx.input.isTouched())
	proyectil.setY(proyectil.getY()+2);
		if(proyectil.getY()>810)
			proyectil.setY(0);
		
		
		if (enemigos1.getX()>800)
		{
			izquierda=true;
		}
		if(enemigos1.getX()<1)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
		enemigos1.setX(enemigos1.getX()-3);
		}
		else
		{
			enemigos1.setX(enemigos1.getX()+3);
		}
		
		
		
		if (enemigos2.getX()>800)
		{
			izquierda=true;
		}
		if(enemigos2.getX()<1)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
		enemigos2.setX(enemigos2.getX()-2);
		}
		else
		{
			enemigos2.setX(enemigos2.getX()+2);
		}
		
		
		if (enemigos3.getX()>800)
		{
			izquierda=true;
		}
		if(enemigos3.getX()<1)
		{
			izquierda = false;
		}

		if (izquierda==true)
		{
		enemigos3.setX(enemigos3.getX()-1);
		}
		else
		{
			enemigos3.setX(enemigos3.getX()+1);
		}
		stage.draw();
		stage.act();
		stage1.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
