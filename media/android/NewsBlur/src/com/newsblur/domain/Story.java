package com.newsblur.domain;

import java.io.Serializable;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.newsblur.database.DatabaseConstants;

public class Story implements Serializable {

	private static final long serialVersionUID = 7629596752129163308L;

	public String id;
	
	@SerializedName("story_permalink")
	public String permalink;

	@SerializedName("share_count")
	public String shareCount;

	@SerializedName("comment_count")
	public String commentCount;

	@SerializedName("read_status")
	public int read;

	@SerializedName("story_tags")
	public String[] tags;

	@SerializedName("source_user_id")
	public String sourceUserId;

	@SerializedName("story_title")
	public String title;

	@SerializedName("short_parsed_date")
	public String date;

	@SerializedName("story_content")
	public String content;

	@SerializedName("story_authors")
	public String authors;

	@SerializedName("story_feed_id")
	public String feedId;

	@SerializedName("intelligence_feed")
	public String intelligenceFeed;
	
	@SerializedName("intelligence_authors")
	public String intelligenceAuthors;

	@SerializedName("intelligence_title")
	public String intelligenceTitle;

	public ContentValues getValues() {
		final ContentValues values = new ContentValues();
		values.put(DatabaseConstants.STORY_ID, id);
		values.put(DatabaseConstants.STORY_TITLE, title);
		values.put(DatabaseConstants.STORY_DATE, date);
		values.put(DatabaseConstants.STORY_CONTENT, content);
		values.put(DatabaseConstants.STORY_PERMALINK, permalink);
		values.put(DatabaseConstants.STORY_COMMENT_COUNT, commentCount);
		values.put(DatabaseConstants.STORY_SHARE_COUNT, shareCount);
		values.put(DatabaseConstants.STORY_AUTHORS, authors);
		values.put(DatabaseConstants.STORY_INTELLIGENCE_AUTHORS, intelligenceAuthors);
		values.put(DatabaseConstants.STORY_INTELLIGENCE_FEED, intelligenceFeed);
		values.put(DatabaseConstants.STORY_TAGS, TextUtils.join(",", tags));
		values.put(DatabaseConstants.STORY_INTELLIGENCE_TITLE, intelligenceTitle);
		values.put(DatabaseConstants.STORY_READ, read);
		values.put(DatabaseConstants.STORY_FEED_ID, feedId);
		return values;
	}
	
	public static Story fromCursor(final Cursor cursor) {
		Story story = new Story();
		story.authors = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_AUTHORS));
		story.content = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_CONTENT));
		story.title = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_TITLE));
		story.date = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_DATE));
		story.shareCount = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_SHARE_COUNT));
		story.commentCount = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_COMMENT_COUNT));
		story.permalink = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_PERMALINK));
		story.intelligenceAuthors = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_INTELLIGENCE_AUTHORS));
		story.intelligenceFeed = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_INTELLIGENCE_FEED));
		story.read = cursor.getInt(cursor.getColumnIndex(DatabaseConstants.STORY_READ));
		story.tags = TextUtils.split(cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_TAGS)), ",");
		story.feedId = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_FEED_ID));
		story.id = cursor.getString(cursor.getColumnIndex(DatabaseConstants.STORY_ID));
		return story;
	}

}
