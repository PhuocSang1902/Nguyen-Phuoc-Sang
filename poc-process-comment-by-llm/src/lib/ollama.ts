// src/lib/ollama.ts
import axios from 'axios';

const inventory = {
  A123: { product: 'T-shirt', color: 'Black', sizes: ['M', 'L'], stock: 10 },
  B456: { product: 'Jeans', color: 'Blue', sizes: ['L', 'XL'], stock: 5 },
  C789: { product: 'Sweater', color: 'Red', sizes: ['S', 'M'], stock: 0 },
  D101: { product: 'Shorts', color: 'Green', sizes: ['M', 'L'], stock: 12 },
};

function inventoryToPrompt(
  inventory: Record<
    string,
    { product: string; color: string; sizes: string[]; stock: number }
  >
) {
  return Object.entries(inventory)
    .map(([code, details]) => {
      return `{${code}: ${details.product}, ${
        details.color
      }, Sizes: ${details.sizes.join('/')}, Stock: ${details.stock} items}`;
    })
    .join(', ');
}

export async function processCommentLocal(comment: string) {
  const inventoryString = inventoryToPrompt(inventory);
  const prompt = `
You are a professional livestream sales assistant.

Your job:
1. If the comment is asking about a product:
   - Check if the product code, size, and color are in stock.
   - If in stock, answer shortly: "[Product] in [Color], size [Size] is available."
   - If out of stock, say: "Sorry, [Product] in [Color], size [Size] is out of stock."

2. If the comment is an order:
   - Extract:
     - Product code(s)
     - Quantity (if any)
     - Size (if any)
     - Color (if any)
     - Phone number (if any)
     - Customer name (if any)
   - If phone number or name is missing:
     - Ask: "Please provide your phone number and name to confirm your order [Product Code]."

3. If the comment is a compliment:
   - Reply: "Thank you for supporting us! 🥰"

4. If the comment is spam, irrelevant, or just emojis:
   - Reply: "Please avoid spamming so we can assist all customers faster."

5. If the comment is unclear, ambiguous, or hard to understand:
   - Politely ask: "Could you please clarify your request or order details?"

⚠️ Important:
- Answer **in the same language** as the comment (Vietnamese or English).
- Be short and direct, no unnecessary explanations.
- Don't translate comments or explain grammar.
- For missing information, politely ask the customer to provide it.
- For unclear comments, ask for clarification in a polite way.

Inventory for checking stock (available in the system):
${inventoryString}

Customer comment: "${comment}"

Assistant response:
  `;

  const response = await axios.post('http://localhost:11434/api/generate', {
    model: 'llama3',
    prompt: prompt,
    temperature: 0.2,
    top_p: 0.8,
    repetition_penalty: 1.2,
    stream: false,
  });

  return response.data.response;
}
