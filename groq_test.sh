curl "https://api.groq.com/openai/v1/chat/completions" \
  -X POST \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer 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" \
  -d '{
         "messages": [
           {
             "role": "user",
             "content": [
               {
                 "type": "text",
                 "text": "Give me the license plate code in this image of a Canadian license plate (using OCR), give me ONLY the code as a plain text 7 character string, without any markdown formatting."
               },
               {
                 "type": "image_url",
                 "image_url": {
                   "url": "'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/2016_Ontario_License_Plate_CBPC-344.jpg/1920px-2016_Ontario_License_Plate_CBPC-344.jpg'"
                 }
               }
             ]
           }
         ],
         "model": "llama-3.2-11b-vision-preview",
         "temperature": 1,
         "max_completion_tokens": 1024,
         "top_p": 1,
         "stream": false,
         "stop": null
      }'
