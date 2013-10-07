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

public class Round1TitleLayer extends CCColorLayer
{
	protected CCLabel _label;
	
	public static CCScene scene(String message)
	{
		CCScene scene = CCScene.node();
		Round1TitleLayer layer = new Round1TitleLayer(ccColor4B.ccc4(255, 255, 255, 255));
		
		layer.getLabel().setString(message);
		
		scene.addChild(layer);
		
		return scene;
	}
	
	public CCLabel getLabel()
	{
		return _label;
	}
	
	protected Round1TitleLayer(ccColor4B color)
	{
		super(color);
		
		
		
		CGSize winSize = CCDirector.sharedDirector().displaySize();
		
		_label = CCLabel.makeLabel("Level 1  Wave 1", "DroidSans", 32);
		_label.setColor(ccColor3B.ccBLACK);
		_label.setPosition(winSize.width / 2.0f, winSize.height / 2.0f);
		addChild(_label);
		
		this.runAction(CCSequence.actions(CCDelayTime.action(3.0f), CCCallFunc.action(this, "gameOverDone")));
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
