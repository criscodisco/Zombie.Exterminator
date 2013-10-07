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

public class MainTitle extends CCColorLayer
{
	protected CCLabel _label;
	
	public static CCScene scene(String message)
	{
		CCScene scene = CCScene.node();
		MainTitle layer = new MainTitle(ccColor4B.ccc4(0,0,0,0));
		
		layer.getLabel().setString(message);
		
		scene.addChild(layer);
		
		return scene;
	}
	
	public CCLabel getLabel()
	{
		return _label;
	}
	
	protected MainTitle(ccColor4B color)
	{
		super(color);
		
		
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		
		_label = CCLabel.makeLabel("ZOMBIE EXTERMINATOR", "DroidSans", 50);
		_label.setColor(ccColor3B.ccRED);
		_label.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		addChild(_label);
		
		this.runAction(CCSequence.actions(CCDelayTime.action(3.0f), CCCallFunc.action(this, "gotoCredits")));
	}
	
	public void gotoCredits()
	{
		CCDirector.sharedDirector().replaceScene(Credits.scene("Programming by Kyle   Graphics by Briz, James, & Micah"));
	}
	
	public void gameOverDone()
	{
		//CCScene scene = GameLayer.scene();
		//CCDirector.sharedDirector().runWithScene(scene);
		
		
		CCDirector.sharedDirector().replaceScene(GameLayer.scene());
	}
	
	@Override
	public boolean ccTouchesEnded(MotionEvent event)
	{
		gameOverDone();
		
		return true;
	}
}
