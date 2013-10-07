package zombie.exterminator;

import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabel;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;

import android.view.MotionEvent;

public class Credits extends CCColorLayer
{
	protected CCLabel _label;
	protected CCLabel _credits;
	
	public static CCScene scene(String message)
	{
		CCScene scene = CCScene.node();
		Credits layer = new Credits(ccColor4B.ccc4(0,0,0,0));
		
		layer.getLabel().setString(message);
		
		scene.addChild(layer);
		
		return scene;
	}
	
	public CCLabel getLabel()
	{
		return _label;
	}
	
	public CCLabel getCredits()
	{
		return _credits;
	}
	
	protected Credits(ccColor4B color)
	{
		super(color);
		
		
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		
		/*_credits = CCLabel.makeLabel("CREDITS:\n Programming by Kyle  \n Zombies by Briz", "DroidSans", 32);
		_credits.setColor(ccColor3B.ccBLACK);
		_credits.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		*/
		_label = CCLabel.makeLabel("put zombie exterminator back", "DroidSans", 32);
		_label.setColor(ccColor3B.ccRED);
		_label.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		addChild(_label);
		
		//addChild(_credits);
		
		this.runAction(CCSequence.actions(CCDelayTime.action(3.0f), CCCallFunc.action(this, "gameOverDone")));
	}
	

	
	
	public void gameOverDone()
	{
		CCScene scene = Round1TitleLayer.scene("Level 1  Wave 1");
		CCDirector.sharedDirector().runWithScene(scene);
		
		
		//CCDirector.sharedDirector().replaceScene(GameLayer.scene());
	}
	
	@Override
	public boolean ccTouchesEnded(MotionEvent event)
	{
		gameOverDone();
		
		return true;
	}
}
