// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.bot.builder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

import java.util.*;



/** 
 Contains recognition results generated by an <see cref="Recognizer"/>.
 
 {@link Recognizer.RecognizeAsync(TurnContext, System.Threading.CancellationToken)}
*/
public class RecognizerResult implements RecognizerConvert
{
	/** 
	 Gets or sets the input text to recognize.
	 
	 <value>
	 Original text to recognizer.
	 </value>
	*/
    @JsonProperty(value = "text")
	private String Text;
	public final String getText()
	{
		return Text;
	}
	public final void setText(String value)
	{
		Text = value;
	}

	/** 
	 Gets or sets the input text as modified by the recognizer, for example for spelling correction.
	 
	 <value>
	 Text modified by recognizer.
	 </value>
	*/
    @JsonProperty(value = "alteredText")
	private String AlteredText;
	public final String getAlteredText()
	{
		return AlteredText;
	}
	public final void setAlteredText(String value)
	{
		AlteredText = value;
	}

	/** 
	 Gets or sets the recognized intents, with the intent as key and the confidence as value.
	 
	 <value>
	 Mapping from intent to information about the intent.
	 </value>
	*/
    @JsonProperty(value = "intents")
    private Map<String, IntentScore> Intents;
	public final Map<String, IntentScore> getIntents()
	{
		return Intents;
	}
	public final void setIntents(Map<String, IntentScore> value)
	{
		Intents = value;
	}

	/** 
	 Gets or sets the recognized top-level entities.
	 
	 <value>
	 Object with each top-level recognized entity as a key.
	 </value>
	*/
    @JsonProperty(value = "entities")
	private JsonObject Entities;
	public final JsonObject getEntities()
	{
		return Entities;
	}
	public final void setEntities(JsonObject value)
	{
		Entities = value;
	}

	/** 
	 Gets or sets properties that are not otherwise defined by the <see cref="RecognizerResult"/> type but that
	 might appear in the REST JSON object.
	 
	 <value>The extended properties for the object.</value>
	 With this, properties not represented in the defined type are not dropped when
	 the JSON object is deserialized, but are instead stored in this property. Such properties
	 will be written to a JSON object when the instance is serialized.
	*/
	private Map<String, Object> Properties = new HashMap<String, Object> ();

    @JsonAnyGetter
	public final Map<String, Object> getProperties()
	{
		return Properties;
	}
	public final void setProperties(Map<String, Object> value)
	{
		Properties = value;
	}

	/** <inheritdoc />
	*/
	public final void Convert(RecognizerResult result)
	{
		setText(result.Text);
		setAlteredText(result.AlteredText);
		setIntents(result.Intents);
		setEntities(result.Entities);
		setProperties(result.Properties);
	}
}