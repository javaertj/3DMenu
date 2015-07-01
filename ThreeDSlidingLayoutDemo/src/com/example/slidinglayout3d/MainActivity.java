package com.example.slidinglayout3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * com.example.slidinglayout3d.MainActivity
 * 
 * @Description:程序的主界面。
 * @author Kebin.Yan
 * @date Create At :2015年7月1日 下午1:08:59
 */
public class MainActivity extends Activity
{

	/**
	 * 侧滑布局对象，用于通过手指滑动将左侧的菜单布局进行显示或隐藏。
	 */
	private ThreeDSlidingLayout slidingLayout;

	/**
	 * menu按钮，点击按钮展示左侧布局，再点击一次隐藏左侧布局。
	 */
	private Button menuButton;

	/**
	 * 放在content布局中的ListView。
	 */
	private ListView contentListView;

	/**
	 * 作用于contentListView的适配器。
	 */
	private ArrayAdapter<String> contentListAdapter;

	/**
	 * 用于填充contentListAdapter的数据源。
	 */
	private String[] contentItems = { "Content Item 1", "Content Item 2", "Content Item 3", "Content Item 4", "Content Item 5", "Content Item 6", "Content Item 7", "Content Item 8", "Content Item 9",
			"Content Item 10", "Content Item 11", "Content Item 12", "Content Item 13", "Content Item 14", "Content Item 15", "Content Item 16" };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		slidingLayout = (ThreeDSlidingLayout) findViewById(R.id.slidingLayout);

		menuButton = (Button) findViewById(R.id.menuButton);
		contentListView = (ListView) findViewById(R.id.contentList);
		contentListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contentItems);
		contentListView.setAdapter(contentListAdapter);
		// 设置content
		slidingLayout.setScrollEvent(contentListView);
		menuButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (slidingLayout.isLeftLayoutVisible())
				{
					slidingLayout.scrollToRightLayout();
				} else
				{
					slidingLayout.scrollToLeftLayout();
				}
			}
		});
		contentListView.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				String text = contentItems[position];
				Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
			}
		});
	}
}